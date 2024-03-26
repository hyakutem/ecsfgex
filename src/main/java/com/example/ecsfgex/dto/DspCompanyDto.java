package com.example.ecsfgex.dto;

import java.util.Comparator;

public class DspCompanyDto implements Comparable<DspCompanyDto> {

    // id
    public Integer id;

    // 名
    public String name;

    public String areaName;

    public String companyCategory;

    public DspCompanyDto() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getCompanyCategory() {
        return companyCategory;
    }

    public void setCompanyCategory(String companyCategory) {
        this.companyCategory = companyCategory;
    }

    /**
     * descending order by Id Company
     */
    public int compareTo(DspCompanyDto compareFruit) {

        int compareQuantity = ((DspCompanyDto) compareFruit).getId();

        // descending order
        return compareQuantity - this.id;

    }

    /**
     * ascending order by Company Name
     */
    public static Comparator<DspCompanyDto> NameComparator = new Comparator<DspCompanyDto>() {

        public int compare(DspCompanyDto fruit1, DspCompanyDto fruit2) {

            String name1 = fruit1.getName().toUpperCase();
            String name2 = fruit2.getName().toUpperCase();

            // ascending order
            return name1.compareTo(name2);

        }

    };

    /**
     * ascending order by Area Name
     */
    public static Comparator<DspCompanyDto> AreaNameComparator = new Comparator<DspCompanyDto>() {

        public int compare(DspCompanyDto fruit1, DspCompanyDto fruit2) {

            String name1 = fruit1.getAreaName().toUpperCase();
            String name2 = fruit2.getAreaName().toUpperCase();

            // ascending order
            return name1.compareTo(name2);

        }

    };

    /**
     * descending order by category Company
     */
    public static Comparator<DspCompanyDto> CompanyCategoryComparator = new Comparator<DspCompanyDto>() {

        public int compare(DspCompanyDto fruit1, DspCompanyDto fruit2) {

            String category1 = fruit1.getCompanyCategory().toUpperCase();
            String category2 = fruit2.getCompanyCategory().toUpperCase();

            // descending order
            return category2.compareTo(category1);

        }

    };
  
}
