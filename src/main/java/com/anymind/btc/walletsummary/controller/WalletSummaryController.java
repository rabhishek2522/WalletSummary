package com.anymind.btc.walletsummary.controller;

import com.anymind.btc.walletsummary.service.WalletSummaryService;
import com.anymind.btc.walletsummary.vo.DateRange;
import com.anymind.btc.walletsummary.vo.HourlyTransactionHistory;
import com.anymind.btc.walletsummary.vo.WalletSummaryDTO;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("wallet")
public class WalletSummaryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WalletSummaryController.class);

    private WalletSummaryService walletSummaryService;

    @PostMapping("/credit")
    public ResponseEntity<String> saveTransaction(@Valid @RequestBody WalletSummaryDTO walletSummaryDTO) {
        LOGGER.info("WalletSummaryController::saveTransaction()::POST API call initiated");
        walletSummaryService.saveTransaction(walletSummaryDTO);
        LOGGER.info("WalletSummaryController::saveTransaction()::POST API call ended");
        return new ResponseEntity<String>("Successfully Credited", HttpStatus.OK);
    }

    @GetMapping(value = "/transactionSummary",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HourlyTransactionHistory>> getHourlyTransactionHistory(@Valid @RequestBody DateRange dateRange) {
        LOGGER.info("WalletSummaryController::getHistoryWithTimeSpan()::GET API call initiated");
        List<HourlyTransactionHistory> walletSummaries = walletSummaryService.getSummary(dateRange);
        LOGGER.info("WalletSummaryController::getHistoryWithTimeSpan()::GET API call ended");
        return new ResponseEntity<List<HourlyTransactionHistory>>(walletSummaries, HttpStatus.OK);
    }
}
