/**
 * Created by Maciek on 2017-01-25.
 */

public class imiona {
    private long rowId;
    private String imie;
    private String plec;


    public imiona(long rowId, String imie, String plec) {
        this.rowId = rowId;
        this.imie = imie;
        this.plec = plec;
    }

    public long getRowId() {
        return rowId;
    }

    public void setRowId(long rowId) {
        this.rowId = rowId;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }
}
