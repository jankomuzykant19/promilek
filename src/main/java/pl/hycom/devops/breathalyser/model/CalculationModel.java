package pl.hycom.devops.breathalyser.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CalculationModel {
    private float weight;
    private float height;
    private int age;
    private boolean sex;
    private float amountOfAlcohol;
    private String startTime;
    private String endTime;
    private String startDate;
    private String endDate;
    private float time;
    private int metabolysmParameter;
    private int foodParameter;
    private String userId;
    private float promiles;
}
