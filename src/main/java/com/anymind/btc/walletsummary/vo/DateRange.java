package com.anymind.btc.walletsummary.vo;

import lombok.Data;
import com.anymind.btc.walletsummary.validator.ValidDateRange;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@ValidDateRange
public class DateRange {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @NotNull(message = "Start Date Time is mandatory")
    private Date startDatetime;

    @NotNull(message = "End Date Time is mandatory")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date endDatetime;

}
