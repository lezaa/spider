package com.keepzzz.film.provider;

import com.keepzzz.film.domain.Snack;
import org.apache.ibatis.jdbc.SQL;

public class SnackProvider {
    public String insertSnack(final Snack snack) {
        return new SQL() {{
            INSERT_INTO("snack");
            if (snack.getSnackName()!= null) {
                VALUES("snack_name", "#{snackName}");
            }
            if (snack.getSnackPrice() != null) {
                VALUES("snack_price", "#{snackPrice}");
            }
            if (snack.getSnackStore() != null) {
                VALUES("snack_store", "#{snackStore}");
            }
            if (snack.getSnackPicture() != null) {
                VALUES("snack_picture", "#{snackPicture}");
            }

        }}.toString();
    }
    public String updateSnack(final Snack snack) {
        return new SQL() {{
            UPDATE("snack");
            if (snack.getSnackName()!= null) {
                SET("snack_name = #{snackName}");
            }
            if (snack.getSnackPrice() != null) {
                SET("snack_price = #{snackPrice}");
            }
            if (snack.getSnackStore() != null) {
                SET("snack_store = #{snackStore}");
            }
            if (snack.getSnackPicture() != null) {
                SET("snack_picture = #{snackPicture}");
            }
            WHERE("id = #{id}");
        }}.toString();
    }
}
