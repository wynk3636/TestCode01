package test01;

public class StoreInfo {
	/**
     * 都道府県
     */
    private String pref;
    /**
     * 市区町村
     */
    private String city;
    /**
     * 事業所名（屋号）
     */
    private String name;
    /**
     * サービス
     */
    private String category1;
    /**
     * サービス（サブカテゴリ）
     */
    private String category2;
    /**
     * 還元率
     */
    private String rate;

    public StoreInfo(String pref, String city, String name, String category1, String category2, String rate) {
        this.pref = pref;
        this.city = city;
        this.name = name;
        this.category1 = category1;
        this.category2 = category2;
        this.rate = rate;
    }

    public boolean isCity(String city) {
        return this.city.equals(city);
    }

    public boolean containsName(String name) {
        return this.name.contains(name);
    }

    public String toString() {
        return String.join(",", pref, city, name, category1, category2, rate);
    }
}
