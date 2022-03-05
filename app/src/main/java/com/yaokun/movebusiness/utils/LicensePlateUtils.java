package com.yaokun.movebusiness.utils;

/***
 * 车牌号工具
 */

public class LicensePlateUtils {

    private static final String LICENSE_PLATE_RE = "/^[\\u4e00-\\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{5}$/";

    public static boolean checkLicensePlate(String LicPlate) {
        if (LicPlate == null) return false;
        return LicPlate.matches(LICENSE_PLATE_RE);
    }
}
