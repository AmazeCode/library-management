package com.book.management.service.impl;

import com.book.management.dao.LendBackMapper;
import com.book.management.model.LendBack;
import com.book.management.service.LendBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class LendBookServiceImpl implements LendBookService {

    @Resource
    private LendBackMapper lendBackMapper;

    @Override
    public int lendBook(LendBack lendBack) throws ParseException {
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String currdate = format.format(d);
        //借出日期
        Date lendDate = format.parse(currdate);
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, lendBack.getShouldLendDays());// num为增加的天数，可以改变的
        d = ca.getTime();
        String enddate = format.format(d);
        //根据应借天数计算应还时间
        Date shouldReturnDate = format.parse(enddate);
        LendBack lendBackInfo = new LendBack();
        //设置图书id
        lendBackInfo.setBookId(lendBack.getBookId());
        //设置用户id
        lendBackInfo.setUserId(lendBack.getUserId());
        //社渚借出日期
        lendBackInfo.setLendDate(lendDate);
        //设置应借天数
        lendBackInfo.setShouldLendDays(lendBack.getShouldLendDays());
        //设置应还天数
        lendBackInfo.setShouldReturnDate(shouldReturnDate);

        return lendBackMapper.insertSelective(lendBackInfo);
    }

    @Override
    public List<LendBack> selectLendReturnRecordByUserId(Map<String, Object> map) throws ParseException{
        List<LendBack> lendReturnLists = lendBackMapper.selectLendReturnRecordByUserId(map);
        for (LendBack lendReturnList : lendReturnLists) {
            Date shouldReturnDate = lendReturnList.getShouldReturnDate();
            Date returnDate = lendReturnList.getReturnDate();
            if (returnDate == null) {
                returnDate = new Date();
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            shouldReturnDate = sdf.parse(sdf.format(shouldReturnDate));
            returnDate = sdf.parse(sdf.format(returnDate));
            Calendar cal = Calendar.getInstance();
            cal.setTime(shouldReturnDate);
            long time1 = cal.getTimeInMillis();
            cal.setTime(returnDate);
            long time2 = cal.getTimeInMillis();
            long between_days = (time2 - time1) / (1000 * 3600 * 24);
            lendReturnList.setExtendedDays(Integer.parseInt(String.valueOf(between_days)));

            lendReturnList.setBookNames(lendReturnList.getBookInfo().getBookName());
        }
        return lendReturnLists;
    }

    @Override
    public int getTotalRecord(Map<String, Object> map) {
        return lendBackMapper.getTotalRecord(map);
    }
}
