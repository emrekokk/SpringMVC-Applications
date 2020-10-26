package controller;
import Connects.DailyData;
import Connects.Roles;
import Connects.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;
import sun.nio.cs.ext.ISO_8859_3;

import javax.jws.WebParam;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class UserController {
    UserDBC ucnt = new UserDBC();

    @RequestMapping("/")
    public String index(Model m)
    {
        /*
        UserDBC userDBC = new UserDBC();
        userDBC.connectDBUser();
        m.addAttribute("someAttribute",userDBC.getUserlist().get(0).getFname());
         */
        return "loginjs"; //JSP DOSYASI
    }
    @ModelAttribute("myday")
    public MyDay createMyDay(){
        return new MyDay();
    }
    @ModelAttribute("user")
    public User createModel() {
        return new User();
    }

    @RequestMapping(value = "/createaccount",method = RequestMethod.GET)
    public ModelAndView datepicker()
    {
        return new ModelAndView("createaccount","newuser",new User());
    }

    @RequestMapping(value = "/createUser",method = RequestMethod.POST)
    public ModelAndView datepick(@ModelAttribute("newuser")User user)
    {
        if( !User.checkUser(user.getUsername()))
        {
            if(String.valueOf(user.getCountryID()) == "" || user.getLname() =="" || user.getFname()=="" || user.getPassword() == "" || user.getUsername() == "")
                return new ModelAndView("createaccount",new ModelMap().addAttribute("stt","1").addAttribute(user));
            User.createUser(user);
            return new ModelAndView("loginjs");
        }
        else
            return new ModelAndView("createaccount",new ModelMap().addAttribute("stt","0").addAttribute(user));
    }

    @RequestMapping(value = "/loginjs",method = RequestMethod.GET)
    public ModelAndView user()
    {
        return new ModelAndView("loginjs","user",new User());
    }

    @RequestMapping(value = "/success",method = RequestMethod.POST)
    public ModelAndView post(@ModelAttribute("user") User user,@ModelAttribute("modifydata") DailyData modifydata,@ModelAttribute("date") LocalDate localDate,ModelMap model)
    {
        System.out.println(localDate.getDayOfMonth());
        User user2 = new User();
        ModelAndView modelDir = null;
        String role = "";
        /*passus = User.findUser(user.getUsername()); user.getPassword() == passus.getPassword()*/

        //if( sifreDogrula(user.getUsername(),user.getPassword(),role) )
        if(sifreDogrula(user))
        {
            /*
            DailyData news = new DailyData();
            model.addAttribute("message","");
            news = CovidDataGetter.getCovidDailyData("2020","05","27",21);
            model.addAttribute("countryid",news.getCountryID());
            model.addAttribute("dailycase",news.getNumCase());
            model.addAttribute("intubated",news.getNumIntubated());
            model.addAttribute("icu",news.getNumICU());
            model.addAttribute("deceased",news.getNumDeceased());
            model.addAttribute("recovered",news.getNumRecovered());
            model.addAttribute("test",news.getNumTest());
            //////
            news = CovidDataGetter.getTotaldata();
            model.addAttribute("tdaily",news.getNumCase());
            model.addAttribute("tintubated",news.getNumIntubated());
            model.addAttribute("ticu",news.getNumICU());
            model.addAttribute("tdeceased",news.getNumDeceased());
            model.addAttribute("trecovered",news.getNumRecovered());
            model.addAttribute("ttest",news.getNumTest());
            model.addAttribute("tmessage",news.getNumDeceased());
             */
            if (user.getRid() == 1) //admin
            {
                return new ModelAndView("Covid19DashboardAdmin",new ModelMap("someAttribute","adminuser").addAttribute(model));
            }
            else {  //standart
                return new ModelAndView("Covid19Dashboard",model);
            }
            //return new ModelAndView("Covid19Dashboard",model);
        }
        else {
            model.addAttribute("result","false");
            model.addAttribute("message","Password Wrong" );
            modelDir = new ModelAndView("loginjs");
            //modelDir.addObject("message",user.getUsername() + "  " +user.getPassword() + "Verified User account");
            return new ModelAndView("loginjs",model);
        }

    }//requestmapping-dailydata

    @ModelAttribute("date")
    public LocalDate createModeldate()
    {
        LocalDate locdate;
        locdate = LocalDate.of(2020,5,27);
        return locdate;
    }
    @RequestMapping(value = "/modifier",method = RequestMethod.GET)
    public ModelAndView modifier()
    {

        return new ModelAndView("index","date",createModeldate());
    }
    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    public ModelAndView post(@ModelAttribute("date") LocalDate localDate, ModelMap model)
    {
        return new ModelAndView("index");
    }



    @RequestMapping(value = "/covid19dashb",method = RequestMethod.POST)
    public ModelAndView dashb(@ModelAttribute("date")LocalDate localDate, ModelMap model,@ModelAttribute("myday")MyDay myDay)
    {
        if(String.valueOf(myDay.getDayof()) == "" || myDay.getMonth() =="" || myDay.getYear()=="")
            return new ModelAndView("Covid19DashboardAdmin",new ModelMap().addAttribute("stt","1").addAttribute(myDay));
        DailyData news = new DailyData();
        System.out.println(localDate.getMonth()+"  " +localDate.getYear());
        DailyData total = CovidDataGetter.getTotaldata();
        System.out.println(myDay.getCountryString());
        int cid = CovidDataGetter.getCountryID(myDay.getCountryString());
        news = CovidDataGetter.getCovidDailyDataByCountry(myDay.getYear(),myDay.getMonth(),myDay.getDayof(),cid);
        model.addAttribute("countryid",news.getCountryID());
        model.addAttribute("dailycase",news.getNumCase());
        model.addAttribute("intubated",news.getNumIntubated());
        model.addAttribute("icu",news.getNumICU());
        model.addAttribute("deceased",news.getNumDeceased());
        model.addAttribute("recovered",news.getNumRecovered());
        model.addAttribute("test",news.getNumTest());
        model.addAttribute("message",news.getNumDeceased());
        //
        model.addAttribute("tdaily",total.getNumCase());
        model.addAttribute("tintubated",total.getNumIntubated());
        model.addAttribute("ticu",total.getNumICU());
        model.addAttribute("tdeceased",total.getNumDeceased());
        model.addAttribute("trecovered",total.getNumRecovered());
        model.addAttribute("ttest",total.getNumTest());
        model.addAttribute("tmessage",total.getNumDeceased());
        return new ModelAndView("Covid19Dashboard",model);
    }
    @RequestMapping("/modifieradmin")
    public ModelAndView modifieradmin(@ModelAttribute("modifydata")DailyData newdata,ModelMap model)
    {
            System.out.println(newdata.getNumCase()+newdata.getNumTest());
            CovidDataModifier x = new CovidDataModifier();
            x.setCovidDailyData(newdata);

        return new ModelAndView("Covid19DashboardAdmin");
    }
    @RequestMapping("/delete")
    public ModelAndView modifieradmin()
    {
        CovidDataModifier.deleteAllData();
        return new ModelAndView("loginjs");
    }
    @RequestMapping("/deleteadmin")
    public ModelAndView delete(@ModelAttribute("modifydata")DailyData newdata,ModelMap model)
    {
        System.out.println(newdata.getNumCase()+newdata.getNumTest());
        CovidDataModifier x = new CovidDataModifier();
        x.deleteCovidDailyData(newdata);
        System.out.println("deleted");

        return new ModelAndView("Covid19DashboardAdmin");
    }
    @RequestMapping(value = "/success2",method = RequestMethod.POST)
    public ModelAndView modified(@ModelAttribute("user") User user,@ModelAttribute("modifydata") DailyData modifydata,@ModelAttribute("date") LocalDate localDate, ModelMap model)
    {
        System.out.println(localDate.getDayOfMonth());
            DailyData news = new DailyData();
            model.addAttribute("message","");

            news = CovidDataGetter.getCovidDailyData(modifydata.getYil(),modifydata.getAy(),modifydata.getGun(),modifydata.getCountryID());
            model.addAttribute("countryid",news.getCountryID());
            model.addAttribute("dailycase",news.getNumCase());
            model.addAttribute("intubated",news.getNumIntubated());
            model.addAttribute("icu",news.getNumICU());
            model.addAttribute("deceased",news.getNumDeceased());
            model.addAttribute("recovered",news.getNumRecovered());
            model.addAttribute("test",news.getNumTest());
            /////////////////////////////////////////////////////
            DailyData total = CovidDataGetter.getTotaldata();
            model.addAttribute("tdaily",total.getNumCase());
            model.addAttribute("tintubated",total.getNumIntubated());
            model.addAttribute("ticu",total.getNumICU());
            model.addAttribute("tdeceased",total.getNumDeceased());
            model.addAttribute("trecovered",total.getNumRecovered());
            model.addAttribute("ttest",total.getNumTest());
            model.addAttribute("tmessage",total.getNumDeceased());
        return new ModelAndView("Covid19DashboardAdmin",model);
    }//requestmapping-dailydata
    @RequestMapping("/newdaily")
    public ModelAndView newdailydata(@ModelAttribute("modifydata")DailyData newdata,ModelMap model)
    {
        System.out.println(newdata.getNumCase()+newdata.getNumTest());
        CovidDataModifier x = new CovidDataModifier();
        x.insertCovidDailyData(newdata);
        System.out.println("inserted");

        return new ModelAndView("Covid19DashboardAdmin");
    }
    @RequestMapping("/chart")
    public ModelAndView chart(ModelMap model, ServletContextResource request){
        //model.addAttribute("",)
        ArrayList<DailyData> x =CovidDataGetter.getDataOrderDay(new MyDay("21","5","2020"),new MyDay("29","5","2020"));
        List<DailyData> list = x;
        model.addAttribute("datapoint",list);

        return new ModelAndView("result",model);
    }


    public static boolean sifreDogrula(String username,String password,String role)
    {
        UserDBC conDB = new UserDBC();
        conDB.connectDBUser();
        ArrayList<User> search = conDB.getUserlist();
        Boolean x = false;
        for (int i=0; i < search.size();i++)
        {
            if(    search.get(i).getPassword().equals(password)
                    && search.get(i).getUsername().equals(username))
            {
                //password true
                role = search.get(i).getRname();
                x = true;
                break;
            }
        }
        return x;
    }
    public static boolean sifreDogrula(User user)
    {
        UserDBC conDB = new UserDBC();
        conDB.connectDBUser();
        ArrayList<User> search = conDB.getUserlist();
        Boolean x = false;
        for (int i=0; i < search.size();i++)
        {
            if(    search.get(i).getPassword().equals(user.getPassword())
                    && search.get(i).getUsername().equals(user.getUsername()))
            {
                //password true
                user.setRid(search.get(i).getRid());
                x = true;
                break;
            }
        }
        return x;
    }
    class MyDay
    {
        public String dayof;
        public String month;
        public String year;
        public int countryid;
        public String countryString;

        public String getCountryString() {
            return countryString;
        }

        public void setCountryString(String countryString) {
            this.countryString = countryString;
        }

        public int getCountryid() {
            return countryid;
        }

        public void setCountryid(int countryid) {
            this.countryid = countryid;
        }

        public MyDay(){
        }

        public MyDay(String dayof, String month, String year) {
            this.dayof = dayof;
            this.month = month;
            this.year = year;
        }

        public String getDayof() {
            return dayof;
        }

        public void setDayof(String dayof) {
            this.dayof = dayof;
        }

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public int getCountrid() {
            return this.countryid;
        }
    }


}

