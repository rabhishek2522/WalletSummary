package com.anymind.btc.walletsummary.service;

import com.anymind.btc.walletsummary.vo.DateRange;
import com.anymind.btc.walletsummary.vo.HourlyTransactionHistory;
import com.anymind.btc.walletsummary.vo.WalletSummaryDTO;

import java.util.List;

public interface WalletSummaryService {

    void saveTransaction(WalletSummaryDTO walletSummaryDTO);
    List<HourlyTransactionHistory> getSummary(DateRange dateRange);
}
