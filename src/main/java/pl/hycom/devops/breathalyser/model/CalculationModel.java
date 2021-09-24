package pl.hycom.devops.breathalyser.model;

public class CalculationModel {
    float weight;
    float height;
    int age;
    boolean sex;
    float amountOfAlcohol;
    String startTime;
    String endTime;
    String startDate;
    String endDate;
    float time;
    int metabolysmParameter;
    int foodParameter;
    String userId;
    float promiles;

    @Override
    public String toString() {
        return "CalculationModel{" +
                "weight=" + weight +
                ", height=" + height +
                ", age=" + age +
                ", sex=" + sex +
                ", amountOfAlcohol=" + amountOfAlcohol +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", time=" + time +
                ", metabolysmParameter='" + metabolysmParameter + '\'' +
                ", foodParameter='" + foodParameter + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public CalculationModel() {
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public float getAmountOfAlcohol() {
        return amountOfAlcohol;
    }

    public void setAmountOfAlcohol(float amountOfAlcohol) {
        this.amountOfAlcohol = amountOfAlcohol;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public int getMetabolysmParameter() {
        return metabolysmParameter;
    }

    public void setMetabolysmParameter(int metabolysmParameter) {
        this.metabolysmParameter = metabolysmParameter;
    }

    public int getFoodParameter() {
        return foodParameter;
    }

    public void setFoodParameter(int foodParameter) {
        this.foodParameter = foodParameter;
    }

    public float getPromiles() {
        return promiles;
    }

    public void setPromiles(float promiles) {
        this.promiles = promiles;
    }
}
