package coreprogramming.programmingelements.level1;

public class VolumeOfEarth {

    public static void main(String[] args) {

        double radiusInKm = 6378;

        double volumeInKmCube =
                (4.0 / 3.0) * Math.PI * Math.pow(radiusInKm, 3);

        double kmToMile = 1 / 1.6;
        double volumeInMilesCube =
                volumeInKmCube * Math.pow(kmToMile, 3);
//miles³ = km³ × (kmToMile)³
        System.out.println(
                "The volume of earth in cubic kilometers is " + volumeInKmCube +
                        " and cubic miles is " + volumeInMilesCube
        );
    }
}
