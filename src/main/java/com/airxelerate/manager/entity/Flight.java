package com.airxelerate.manager.entity;

import com.airxelerate.manager.service.validation.FlightNumberValidation;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    @Column
    @Size(max = 3, message = "invalid iataCarrierCode, should be less than 3 letters")
    private String iataCarrierCode;
    @NotNull
    @Column
    @Size(max = 3, message = "invalid originAirportCode, should be less than 3 letters")
    private String originAirportCode;
    @NotNull
    @Column
    @Size(max = 3, message = "invalid destinationAirportCode, should be less than 3 letters")
    private String destinationAirportCode;
    @NotNull
    @Column
    private Date departureDate;
    @Column
    @NotNull
    @FlightNumberValidation(message = "Invalid number. Should contain 4 digits. 0 is possible at start")
    private String number;

}
