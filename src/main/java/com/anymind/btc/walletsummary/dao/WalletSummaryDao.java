package com.anymind.btc.walletsummary.dao;

import com.anymind.btc.walletsummary.entity.WalletSummary;
import com.anymind.btc.walletsummary.vo.HourlyTransactionHistory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
public interface WalletSummaryDao extends CrudRepository<WalletSummary, Long> {

    @Query(nativeQuery = true, value = "select max(current_balance) as amount, CONCAT(DATE(credited_date_time),' ',HOUR(credited_date_time), ':00', ':00') as dateTime from wallet_summary where credited_date_time BETWEEN :startDatetime AND :endDatetime GROUP BY HOUR(credited_date_time)")
    List<HourlyTransactionHistory> fetchWalletSummary(@Param("startDatetime") Date startDatetime, @Param("endDatetime") Date endDatetime);

    @Query("SELECT  max(ws.currentBalance) FROM WalletSummary ws")
    Double getCurrentBalance();

    @Query("SELECT  max(ws.creditedDateTime) FROM WalletSummary ws")
    Date getCreditedDateTime();

}
