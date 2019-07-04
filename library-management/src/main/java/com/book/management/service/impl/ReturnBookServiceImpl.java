package com.book.management.service.impl;

import com.book.management.dao.LendBackMapper;
import com.book.management.model.LendBack;
import com.book.management.service.ReturnBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ReturnBookServiceImpl implements ReturnBookService {

    @Resource
    private LendBackMapper lendBackMapper;

    @Override
    public List<LendBack> selectBookInfoAndUserByBookId(Integer bookId) throws ParseException {
        List<LendBack> lendReturnLists = lendBackMapper.selectBookInfoAndUserByBookId(bookId);
        for (LendBack lendBack : lendReturnLists) {
            Date shouldReturnDate = lendBack.getShouldReturnDate();
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            shouldReturnDate = sdf.parse(sdf.format(shouldReturnDate));
            now = sdf.parse(sdf.format(now));
            Calendar cal = Calendar.getInstance();
            cal.setTime(shouldReturnDate);
            long time1 = cal.getTimeInMillis();
            cal.setTime(now);
            long time2 = cal.getTimeInMillis();
            long between_days = (time2 - time1) / (1000 * 3600 * 24);
            //延长天数
            lendBack.setExtendedDays(Integer.parseInt(String.valueOf(between_days)));
        }
        return lendReturnLists;
    }

    @Override
    public int returnBook(LendBack lendBack) throws ParseException{
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String currdate = format.format(d);
        //归还日期
        Date returnDate = format.parse(currdate);
        LendBack back = new LendBack();
        //借出id
        back.setId(lendBack.getId());
        back.setReturnDate(lendBack.getReturnDate());
        back.setIsDamage(lendBack.getIsDamage());
        back.setDamageDegree(lendBack.getDamageDegree());
        back.setReturnDate(new Date());
        back.setNote(lendBack.getNote());
        return lendBackMapper.updateByPrimaryKeySelective(back);
    }
}
