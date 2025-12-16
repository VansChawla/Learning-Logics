public class ConvertTemperature {
    public double[] convertTemperature(double celsius) {
        double temp[] = new double[2];
        double fahrenheit = (celsius * 1.8) + 32;
        double kelvin = celsius + 273.15;

        temp[0] = kelvin;
        temp[1] = fahrenheit;

        return temp;
    }
}
