package pl.hycom.devops.breathalyser.service;

import org.springframework.stereotype.Service;
import pl.hycom.devops.breathalyser.model.CalculationModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class CalculationService {

    public static long getDateDiff(String dateString1, String dateString2, String hourString1, String hourString2, TimeUnit timeUnit) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date1 = format.parse(dateString1 + " " + hourString1);
        Date date2 = format.parse(dateString2 + " " + hourString2);
        long diffInMillies = Math.abs(date2.getTime() - date1.getTime());
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    public static void calculatePromiles(CalculationModel calculationModel) {
        float alcoholMas = (float) (calculationModel.getAmountOfAlcohol() * 0.789);
        float bodyWater;
        float weight = calculationModel.getWeight();
        float metabolizm = 0;
        float time = calculationModel.getTime();
        if (calculationModel.isSex()) {
            bodyWater = (float) 0.68;
            if (calculationModel.getMetabolysmParameter() == 1) {
                metabolizm = (float) 0.013;
            }
            if (calculationModel.getMetabolysmParameter() == 2) {
                metabolizm = (float) 0.015;
            }
            if (calculationModel.getMetabolysmParameter() == 3) {
                metabolizm = (float) 0.017;
            }
        } else {
            bodyWater = (float) 0.55;
            if (calculationModel.getMetabolysmParameter() == 1) {
                metabolizm = (float) 0.014;
            }
            if (calculationModel.getMetabolysmParameter() == 2) {
                metabolizm = (float) 0.017;
            }
            if (calculationModel.getMetabolysmParameter() == 3) {
                metabolizm = (float) 0.021;
            }
        }
        float EBAC = alcoholMas / (bodyWater * weight) - metabolizm * time;
        calculationModel.setPromiles((float) (EBAC * 1.055));
    }

}
