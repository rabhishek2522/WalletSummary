package com.anymind.btc.walletsummary.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "wallet_summary")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "credited_date_time")
    private Date creditedDateTime;

    @Column(name = "current_balance")
    private Double currentBalance;

}
