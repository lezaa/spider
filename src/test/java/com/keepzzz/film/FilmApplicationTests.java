package com.keepzzz.film;

import com.keepzzz.film.domain.Area;
import com.keepzzz.film.domain.Film;
import com.keepzzz.film.domain.User;
import com.keepzzz.film.mapper.AreaMapper;
import com.keepzzz.film.mapper.FilmMapper;
import com.keepzzz.film.mapper.UserMapper;
import com.keepzzz.film.service.FilmService;
import com.keepzzz.film.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FilmApplicationTests {

    @Autowired
    private FilmMapper filmMapper;

    @Autowired
    private AreaMapper areaMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FilmService filmService;

    @Test
    public void contextLoads() {
        List<Film> films = filmMapper.getAll();
        for (Film film : films) {
            System.out.println(film.getFilmName());
        }
    }

    @Test
    public void testSelect(){
        List<Film> flim = filmMapper.getAll();
        System.out.println(flim.size());
    }

    @Test
    public void testInsert(){
        Film film = new Film();
        film.setAreaId(2L);
        film.setSortId(9L);
        film.setFilmName("寒战");
        film.setFilmDirector("陆剑青 梁乐民");
        film.setFilmPlayers("郭富城 梁家辉 刘德华");
        film.setFilmIntro("午夜的警队，报案中心接到匿名电话，一辆前线冲锋车被胁持。车内五位警员及武器装备成为贼人谈判筹码。事件惊动警队，冲锋车内其中被劫持的警员，竟为现任行动副处长李文彬独子（彭于晏 饰）！适逢警队一哥外访未返，下任处长选举的两大热门：鹰派人物李文彬（梁家辉 饰）与年轻的警长刘杰辉（郭富城 饰）都开始大施拳脚。李立即指挥营救，并将此次行动代号为（寒战）。可贼人竟对警队内部一切了如指掌、洞悉先机，警队精英尽出 ，行动依然无功而返，处处受制，众同袍均开始怀疑他的决策，推举刘杰辉接手整个行动，危急时刻，二虎相争，刘杰辉毫不示弱，不同与李的激进手法，他选择主动与贼人沟通，并答应交予贼人赎金。整个交收赎金过程中，刘设法令赎金留下线索，以便追查贼人位置。可道高一尺，魔高一丈，刘非但找不着贼人踪迹，还将巨额赎金失却，跟刘出生入死的同袍徐永基（钱嘉乐 饰）更在交收赎金过程中殉职，刘内疚不已。事件不但惊动了政府内部，也惊动了廉政公署，因为廉署收到匿名人士举报，怀疑两位副处长，其中一人在此危急关头以权谋私……香港的安全瞬时沦陷，警队及香港的管治漏洞被抖出，威胁直逼警队内部，矛头直指警队高层。");
        film.setFilmPhoto("10.jpg");
        film.setFilmTime(110L);
        film.setFilmLanguage("国语");
        film.setFilmPrice(50.00);
        film.setStatu(1L);
        film.setPlayTime(new Date());

        filmMapper.insert(film);

    }


    @Test
    public void testUpdate(){
        Film film = new Film();
        film.setId(9L);
        film.setFilmName("寒战Ⅱ");

        filmMapper.update(film);
    }

    @Test
    public void testdelete(){
        filmMapper.delete(9);
    }

    @Test
    public void testselect(){
        List<Area> areas = areaMapper.getAreas();
        for(Area area : areas){
            System.out.println(area.getZone());
        }
    }

    @Test
    public void testSelectUser(){

    }

    @Test
    public void testCheck(){

        String token="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJrZWVwenp6IiwiaWQiOjEsInVzZXJuYW1lIjoiZmVuZyIsInBob25lIjoiMTUwODAwMzQyMzEiLCJpYXQiOjE1Njg5NDY5OTQsImV4cCI6MTU2OTU1MTc5NH0.YSLt6fwBt-UfIRABVviyIpmjl1xKgUIeNROeDdgboLQ";
        Claims claims= JwtUtil.checkJWT(token);
        if(claims!=null){
            String name=(String)claims.get("username");
            Integer id=(Integer)claims.get("id");
            String phone=(String)claims.get("phone");
            System.out.println(name);
            System.out.println(id);
            System.out.println(phone);
        }
    }

    @Test
    public void addFilm(){

        Film film = new Film();
        film.setAreaId(2L);
        film.setSortId(9L);
        film.setFilmName("寒战Ⅱ");
        film.setFilmDirector("陆剑青 梁乐民");
        film.setFilmPlayers("郭富城 梁家辉 刘德华");
        film.setFilmIntro("午夜的警队，报案中心接到匿名电话，一辆前线冲锋车被胁持。车内五位警员及武器装备成为贼人谈判筹码。事件惊动警队，冲锋车内其中被劫持的警员，竟为现任行动副处长李文彬独子（彭于晏 饰）！适逢警队一哥外访未返，下任处长选举的两大热门：鹰派人物李文彬（梁家辉 饰）与年轻的警长刘杰辉（郭富城 饰）都开始大施拳脚。李立即指挥营救，并将此次行动代号为（寒战）。可贼人竟对警队内部一切了如指掌、洞悉先机，警队精英尽出 ，行动依然无功而返，处处受制，众同袍均开始怀疑他的决策，推举刘杰辉接手整个行动，危急时刻，二虎相争，刘杰辉毫不示弱，不同与李的激进手法，他选择主动与贼人沟通，并答应交予贼人赎金。整个交收赎金过程中，刘设法令赎金留下线索，以便追查贼人位置。可道高一尺，魔高一丈，刘非但找不着贼人踪迹，还将巨额赎金失却，跟刘出生入死的同袍徐永基（钱嘉乐 饰）更在交收赎金过程中殉职，刘内疚不已。事件不但惊动了政府内部，也惊动了廉政公署，因为廉署收到匿名人士举报，怀疑两位副处长，其中一人在此危急关头以权谋私……香港的安全瞬时沦陷，警队及香港的管治漏洞被抖出，威胁直逼警队内部，矛头直指警队高层。");
        film.setFilmPhoto("10.jpg");
        film.setFilmTime(110L);
        film.setFilmLanguage("国语");
        film.setFilmPrice(50.00);
        film.setStatu(1L);
        film.setPlayTime(new Date());

        filmService.addFilm(film);

    }


    @Test
    public void getFilm(){
        Film filmInfo = filmService.getFilmInfo(11);
        System.out.println(filmInfo.toString());
    }
}
