package com.yangwang.application.pet.market.service.spring.signIn;

import com.yangwang.application.pet.market.dao.market.signIn.SignInMapper;
import com.yangwang.application.pet.market.model.common.signIn.SignIn;
import com.yangwang.application.pet.market.model.common.signIn.SignInHistory;
import com.yangwang.application.pet.market.model.common.signIn.SignInPeriod;
import com.yangwang.application.pet.market.service.facade.signIn.SignInHistoryService;
import com.yangwang.application.pet.market.service.facade.signIn.SignInPeriodService;
import com.yangwang.application.pet.market.service.facade.signIn.SignInService;
import com.yangwang.sysframework.utils.DateUtil;
import com.yangwang.sysframework.utils.TypeConvertUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 签到记录实现类
 */
@Service
public class SignInServiceImpl implements SignInService {

    @Resource
    SignInMapper signInMapper;

    @Resource
    SignInPeriodService signInPeriodService;

    @Resource
    SignInHistoryService signInHistoryService;

    @Override
    public int signIn(String businessNo) {
        //查看用户是否签到过
        SignIn sign = signInMapper.getByBusinessNo(businessNo);
        Integer bonusPoints = 0;
        if(sign == null){   //没签到过
            //获取第一天的签到奖励
            SignInPeriod signInPeriod = signInPeriodService.getBySn(1);
            bonusPoints = signInPeriod.getBonusPoints();
            sign = new SignIn.Builder()
                    .businessNo(businessNo)
                    .continueTimes(1)
                    .signInCount(1)
                    .awardCount(bonusPoints)
                    .sn(1)
                    .build();
        }else if(!isRenewal(businessNo)){      //签到过，但是断签了
            //获取第一天的签到奖励(签到奖励重新计算)
            SignInPeriod signInPeriod = signInPeriodService.getBySn(1);
            bonusPoints = signInPeriod.getBonusPoints();
            sign = new SignIn.Builder()
                    .businessNo(businessNo)
                    .continueTimes(1)   //连续签到1天
                    .signInCount(sign.getSignInCount() + 1)      //签到总天数+1
                    .awardCount(sign.getAwardCount() + bonusPoints)     //签到总积分增加
                    .sn(1)  //与签到周期同步
                    .build();
        }else{      //签到并且是续签
            //获取签到周期总天数
            int count = signInPeriodService.countList();
            //获取签到奖励
            SignInPeriod signInPeriod = signInPeriodService.getBySn(sign.getSn() < count ? sign.getSn() + 1 : 1);
            bonusPoints = signInPeriod.getBonusPoints();
            sign = new SignIn.Builder()
                    .businessNo(businessNo)
                    .continueTimes(sign.getContinueTimes()+1)   //连续签到天数+1
                    .signInCount(sign.getSignInCount()+1)      //签到总天数+1
                    .awardCount(sign.getAwardCount() + bonusPoints)   //签到总积分+1
                    .sn(signInPeriod.getSn())  //与签到周期同步
                    .build();
        }
        //插入签到记录
        signInMapper.saveOrUpdate(sign);
        //插入签到历史记录
        Date now = new Date();
        DateUtil.format(now, DateUtil.FORMAT_TIME);
        SignInHistory signInHistory = new SignInHistory.Bulider()
                .businessNo(businessNo)
                .rewardPoints(bonusPoints)
                .date(DateUtil.format(now, DateUtil.FORMAT_SIMPLE))
                .time(DateUtil.format(now, DateUtil.FORMAT_TIME))
                .week(TypeConvertUtil.$Str(DateUtil.getDayOfWeek(now)))
                .build();
        signInHistoryService.save(signInHistory);
        return 1;
    }

    @Override
    public SignIn getByBusinessNo(String businessNo) {
        return signInMapper.getByBusinessNo(businessNo);
    }

    @Override
    public boolean signInOrNot(String businessNo) {
        //获取用户最近的一次签到记录
        SignInHistory history = signInHistoryService.getLastByBusinessNo(businessNo);
        if(history == null){
            return false;
        }
        //获取当前日期
        Date now = new Date();
        String format = DateUtil.format(now, DateUtil.FORMAT_SIMPLE);
        if(format.equals(history.getDate())){
            return true;
        }
        return false;
    }

    /**
     * 判断当前用户签到是否是连续签到
     * @param businessNo
     * @return
     */
    private boolean isRenewal(String businessNo) {
        //获取用户最近的一次签到记录
        SignInHistory history = signInHistoryService.getLastByBusinessNo(businessNo);
        if(history == null){
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //获取昨天的日期
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,-24);
        String yesterday = sdf.format(calendar.getTime());
        if(yesterday.equals(history.getDate())){
            return true;
        }
        return false;
    }
}
