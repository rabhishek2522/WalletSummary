package com.anymind.btc.walletsummary.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
public class WalletSummaryDTO {

    @NotNull(message = "Amount is mandatory")
    private Double amount;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @NotNull(message = "Date Time is mandatory")
    private Date datetime;
}
