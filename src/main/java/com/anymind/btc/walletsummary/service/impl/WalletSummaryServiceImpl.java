package com.anymind.btc.walletsummary.service.impl;

import com.anymind.btc.walletsummary.dao.WalletSummaryDao;
import com.anymind.btc.walletsummary.entity.WalletSummary;
import com.anymind.btc.walletsummary.service.WalletSummaryService;
import com.anymind.btc.walletsummary.vo.DateRange;
import com.anymind.btc.walletsummary.vo.HourlyTransactionHistory;
import com.anymind.btc.walletsummary.vo.WalletSummaryDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.anymind.btc.walletsummary.exception.InvalidDataException.invalidData;

@Service
@AllArgsConstructor
public class WalletSummaryServiceImpl implements WalletSummaryService {

    private static final Double BTC_MIN_VALUE = 0.0;

    private WalletSummaryDao walletSummaryDao;

    @Override
    public void saveTransaction(WalletSummaryDTO walletSummaryDTO) {

        validateDateTime(walletSummaryDTO);

        WalletSummary walletSummary = getWalletSummaryObj(walletSummaryDTO);

        walletSummaryDao.save(walletSummary);
    }

    private WalletSummary getWalletSummaryObj(WalletSummaryDTO walletSummaryDTO) {
        WalletSummary walletSummary = new WalletSummary();
        walletSummary.setAmount(walletSummaryDTO.getAmount());
        walletSummary.setCreditedDateTime(dateToUTC(walletSummaryDTO.getDatetime()));
        Double currentWalletBalance = walletSummaryDao.getCurrentBalance();
        if (null == currentWalletBalance || currentWalletBalance < BTC_MIN_VALUE) {
            currentWalletBalance = walletSummaryDTO.getAmount();
        } else {
            currentWalletBalance += walletSummaryDTO.getAmount();
        }
        walletSummary.setCurrentBalance(currentWalletBalance);
        return walletSummary;
    }

    private void validateDateTime(WalletSummaryDTO walletSummaryDTO) {
        Date lastCreditedDate = walletSummaryDao.getCreditedDateTime();
        if (null != lastCreditedDate && lastCreditedDate.after(dateToUTC(walletSummaryDTO.getDatetime()))) {
            invalidData("Please Enter the valid dateTime");
        }
    }

    @Override
    public List<HourlyTransactionHistory> getSummary(DateRange dateRange) {
        return walletSummaryDao.fetchWalletSummary(dateToUTC(dateRange.getStartDatetime()), dateToUTC(dateRange.getEndDatetime()));
    }

    private Date dateToUTC(Date date) {
        return new Date(date.getTime() - Calendar.getInstance().getTimeZone().getOffset(date.getTime()));
    }
}
