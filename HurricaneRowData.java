//Name: Andrew Erickson

public class HurricaneRowData {
    //Initialize the variables based on column headers
    private int year;
    private int aceIndex;
    private int numTropStorms;
    private int numHurricanesCat_1_5;
    private int numHurricanesCat_3_5;

    //Constructs a HurricaneRowData object, which holds the data from the columns in the provided csv
    public HurricaneRowData(int year, int aceIndex, int numTropStorms, int numHurricanesCat_1_5, int numHurricanesCat_3_5) {
        this.year=year;
        this.aceIndex=aceIndex;
        this.numTropStorms=numTropStorms;
        this.numHurricanesCat_1_5=numHurricanesCat_1_5;
        this.numHurricanesCat_3_5=numHurricanesCat_3_5;
    }

    //Get the year (used in main)
    public int getYear() {
        return year;
    }

    //Get the ACE index (used in main)
    public int getAceIndex() {
        return aceIndex;
    }

    //No other getters or setters are needed for the purpose of this assignment

    //Override the native toString() method with a better representation of this object
    @Override
    public String toString() {
        return "Year: " + year + "\n" +
                "ACE Index: " + aceIndex + "\n" +
                "# Of Tropical Storms: " + numTropStorms + "\n" +
                "Total # of Hurricanes (Cat 1-5): " + numHurricanesCat_1_5 + "\n" +
                "# of Major Hurricanes (Cat 3-5): " + numHurricanesCat_3_5;
    }
}
