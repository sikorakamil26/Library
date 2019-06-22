package model;

import java.io.Serializable;
import java.util.Objects;
import java.time.Year;

public abstract class Publication implements Serializable, Comparable<Publication>, CsvConvertible {
    private String title;
    private String publisher;
    private Year year;

    Publication(String title, String publisher, int year) {
        this.title = title;
        this.publisher = publisher;
        this.year = Year.of(year);
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publication that = (Publication) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(publisher, that.publisher) &&
                Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, publisher, year);
    }

    @Override
    public int compareTo(Publication o) {
        return title.compareToIgnoreCase(o.title);//"IgnoreCase" nie zwraca uwagi na duże/małe litery
    }
}