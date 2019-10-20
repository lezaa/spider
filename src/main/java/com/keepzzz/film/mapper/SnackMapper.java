package com.keepzzz.film.mapper;

import com.keepzzz.film.domain.Snack;
import com.keepzzz.film.provider.SnackProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

public interface SnackMapper {
    /**
     * 查询所有零食
     * @return
     */
    @Select("select * from snack")
    List<Snack> getSnacks();

    /**
     * 根据id查询零食
     * @return
     */
    @Select("select * from snack where id = #{id}")
    Snack getSnack(Long id);

    /**
     * 添加零食
     * @param snack
     * @return
     */
    @InsertProvider(type = SnackProvider.class,method = "insertSnack")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    int insert(Snack snack);

    /**
     * 修改零食
     * @param snack
     * @return
     */
    @UpdateProvider(type = SnackProvider.class,method = "updateSnack")
    int update(Snack snack);
}
