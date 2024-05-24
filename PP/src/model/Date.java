package PP.src.model;


public class Date {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return year + "-" + String.format("%02d", month) + "-" + String.format("%02d", day);
    }

    public static Date fromString(String dateStr) {
        String[] parts = dateStr.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        return new Date(year, month, day);
    }

    // Méthode pour vérifier si une date est avant une autre
    public boolean isBefore(Date other) {
        if (this.year < other.year) return true;
        if (this.year == other.year && this.month < other.month) return true;
        return this.year == other.year && this.month == other.month && this.day < other.day;
    }

    // Méthode pour vérifier si une date est après une autre
    public boolean isAfter(Date other) {
        if (this.year > other.year) return true;
        if (this.year == other.year && this.month > other.month) return true;
        return this.year == other.year && this.month == other.month && this.day > other.day;
    }

    // Méthode pour vérifier si deux dates sont égales
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Date date = (Date) obj;
        return year == date.year && month == date.month && day == date.day;
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + month;
        result = 31 * result + day;
        return result;
    }
}

