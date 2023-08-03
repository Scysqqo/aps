package com.aps.aps.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpSession;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.aps.aps.Dao.ConfigActivityDao;
import com.aps.aps.Dao.QualAnalyticsDao;
import com.aps.aps.Dao.UserDao;
import com.aps.aps.Models.Analytic;
import com.aps.aps.Models.Analytica;
import com.aps.aps.Models.Answer;
import com.aps.aps.Models.Campo;
import com.aps.aps.Models.ConfigActivity;
import com.aps.aps.Models.QualAnalytics;
import com.aps.aps.Models.Registry;

@ComponentScan
@RestController
@RequestMapping("/")
class ApiControllers {

    @GetMapping(value = "/")
    public ModelAndView index(String message) {
        ModelAndView mv = new ModelAndView("index.html");
        String a = getJson().getName();
        mv.addObject("name", a);
        if (message != null) {
            if (message.equalsIgnoreCase("Login Sucessfull!"))
                mv.addObject("loginSuccess", message);
            else
                mv.addObject("loginError", message);
        }
        return mv;
    }

    @RequestMapping(value = "/config_url", method = RequestMethod.POST)
    @GetMapping
    public ModelAndView getConfiActivity() {
        ModelAndView mv = new ModelAndView("configActivity.html");
        mv.addObject("name", "resumo");
        mv.addObject("type", "text");

        List<Campo> lc = getJson().getJson_params_url();
        List<Campo> lc2 = new ArrayList<>();

        for (Campo c : lc) {
            if (!c.isAnswerProfessor())
                lc2.add(c);
        }

        mv.addObject("campos", lc2);

        return mv;
    }

    @RequestMapping(value = "/save_config_url", method = RequestMethod.POST)
    @GetMapping
    public ModelAndView getConfiActivity2(@ModelAttribute ConfigActivity configActivity) {

        ConfigActivityDao configActivityDao = new ConfigActivityDao();
        getJsonAndCreateDataBase();
        configActivityDao.activeCofigActivictyRow();
        configActivity.setUrlpdfstatus("N");
        int a = 0;
        for (Campo c : getJsonParamUrl()) {

            switch (a) {
                case 0: {
                    configActivityDao.updateActivictyColumn(c.getName(), configActivity.getUrlpdf());
                    break;
                }
                case 1: {
                    configActivityDao.updateActivictyColumn(c.getName(), configActivity.getUrlpdfstatus());
                    break;
                }

                case 2: {
                    configActivityDao.updateActivictyColumn(c.getName(), configActivity.getQuestao1());
                    break;
                }
                case 3: {
                    configActivityDao.updateActivictyColumn(c.getName(), configActivity.getQuestao1status());
                    break;
                }

                case 4: {
                    configActivityDao.updateActivictyColumn(c.getName(), configActivity.getQuestao2());
                    break;
                }
                case 5: {
                    configActivityDao.updateActivictyColumn(c.getName(), configActivity.getQuestao2status());
                    break;
                }

                case 6: {
                    configActivityDao.updateActivictyColumn(c.getName(), configActivity.getQuestao3());
                    break;
                }
                case 7: {
                    configActivityDao.updateActivictyColumn(c.getName(), configActivity.getQuestao3status());
                    break;
                }

                case 8: {
                    configActivityDao.updateActivictyColumn(c.getName(), configActivity.getQuestao4());
                    break;
                }
                case 9: {
                    configActivityDao.updateActivictyColumn(c.getName(), configActivity.getQuestao4status());
                    break;
                }

                case 10: {
                    configActivityDao.updateActivictyColumn(c.getName(), configActivity.getQuestao5());
                    break;
                }
                case 11: {
                    configActivityDao.updateActivictyColumn(c.getName(), configActivity.getQuestao5status());
                    break;
                }

                case 12: {
                    configActivityDao.updateActivictyColumn(c.getName(), configActivity.getQuestao6());
                    break;
                }
                case 13: {
                    configActivityDao.updateActivictyColumn(c.getName(), configActivity.getQuestao6status());
                    break;
                }

                case 14: {
                    configActivityDao.updateActivictyColumn(c.getName(), configActivity.getQuestao7());
                    break;
                }
                case 15: {
                    configActivityDao.updateActivictyColumn(c.getName(), configActivity.getQuestao7status());
                    break;
                }

                case 16: {
                    configActivityDao.updateActivictyColumn(c.getName(), configActivity.getQuestao8());
                    break;
                }
                case 17: {
                    configActivityDao.updateActivictyColumn(c.getName(), configActivity.getQuestao8status());
                    break;
                }

                case 18: {
                    configActivityDao.updateActivictyColumn(c.getName(), configActivity.getQuestao9());
                    break;
                }
                case 19: {
                    configActivityDao.updateActivictyColumn(c.getName(), configActivity.getQuestao9status());
                    break;
                }

                case 20: {
                    configActivityDao.updateActivictyColumn(c.getName(), configActivity.getQuestao10());
                    break;
                }
                case 21: {
                    configActivityDao.updateActivictyColumn(c.getName(), configActivity.getQuestao10status());
                    break;
                }
            }
            a++;
        }

        ModelAndView mv = new ModelAndView("index.html");

        return mv;
    }

    @RequestMapping(value = "/json_params_url", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping
    public List<Campo> getJsonParamUrl() {

        return getJson().getJson_params_url();
    }

    @RequestMapping(value = "/analytics_url", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping
    public ModelAndView getAnalytics_Url() {

        QualAnalyticsDao qualAnalyticsDao = new QualAnalyticsDao();
        ModelAndView mv = new ModelAndView("qualAnalytics.html");
        ConfigActivityDao cd = new ConfigActivityDao();

        List<Campo> lcUser = getJson().getJson_params_url();
        ConfigActivity configActivity = cd.getActivity(lcUser.size());
        List<QualAnalytics> lcUse = qualAnalyticsDao.getQualAnalytics();
        List<QualAnalytics> lcUse2 = new ArrayList<>();
        int cont = configActivity.getNumberQuestions();
        int aux = cont;

        String titulo = getJson().getName();
        mv.addObject("name", titulo);

        mv.addObject("numero", "Nº");
        mv.addObject("nome", "Nome do estudante");
        

        String style="color: black;font-weight: bold; font-size: 15px; border: black; font-family: Calibri";

        mv.addObject("u1", "display: none");
        mv.addObject("s1", "display: none");
        mv.addObject("s2", "display: none");
        mv.addObject("s3", "display: none");
        mv.addObject("s4", "display: none");
        mv.addObject("s5", "display: none");
        mv.addObject("s6", "display: none");
        mv.addObject("s7", "display: none");
        mv.addObject("s8", "display: none");
        mv.addObject("s9", "display: none");
        mv.addObject("s10", "display: none");
        
        List<Analytica> lc = getJson().getQualAnalytics();
        int ur=0,a1=0,a2=0,a3=0,a4=0,a5=0,a6=0,a7=0,a8=0,a9=0,a10=0;

        for(Analytica a:lc){
            if(a.getName().equalsIgnoreCase("urlpdf")) ur=1;
            if(a.getName().equalsIgnoreCase("questao1")) a1=1;
            if(a.getName().equalsIgnoreCase("questao2")) a2=1;
            if(a.getName().equalsIgnoreCase("questao3")) a3=1;
            if(a.getName().equalsIgnoreCase("questao4")) a4=1;
            if(a.getName().equalsIgnoreCase("questao5")) a5=1;
            if(a.getName().equalsIgnoreCase("questao6")) a6=1;
            if(a.getName().equalsIgnoreCase("questao7")) a7=1;
            if(a.getName().equalsIgnoreCase("questao8")) a8=1;
            if(a.getName().equalsIgnoreCase("questao9")) a9=1;
            if(a.getName().equalsIgnoreCase("questao10")) a10=1;
            
        }

        if(ur>0){
            mv.addObject("u1", style);
            mv.addObject("url", "Leu PDF");
        }
        

        if (cont > 0 && a1>0) {
            mv.addObject("s1", style);
            mv.addObject("q1", "Acertou Pergunta1");
        }
        cont--;
        System.out.println(cont);
        if (cont > 0 && a2>0) {
            mv.addObject("s2", style);
            mv.addObject("q2", "Acertou Pergunta2");
        }
        cont--;

        if (cont > 0 && a3>0) {
            mv.addObject("s3", style);
            mv.addObject("q3", "Acertou Pergunta3");
        }
        cont--;
        if (cont > 0 && a4>0) {
            mv.addObject("s4", style);
            mv.addObject("q4", "Acertou Pergunta4");
        }
        cont--;
        if (cont > 0 && a5>0) {
            mv.addObject("s5", style);
            mv.addObject("q5", "Acertou Pergunta5");
        }
        cont--;

        if (cont > 0 && a6>0) {
            mv.addObject("s6", style);
            mv.addObject("q6", "Acertou Pergunta6");
        }
        cont--;
        if (cont > 0 && a7>0) {
            mv.addObject("s7", style);
            mv.addObject("q7", "Acertou Pergunta7");
        }
        cont--;

        if (cont > 0 && a8>0) {
            mv.addObject("s8", style);
            mv.addObject("q8", "Acertou Pergunta8");
        }
        cont--;

        if (cont > 0 && a9>0) {
            mv.addObject("s9", style);
            mv.addObject("q9", "Acertou Pergunta9");
        }
        cont--;

        if (cont > 0 && a10>0) {

            mv.addObject("s10", style);
            mv.addObject("q10", "Acertou Pergunta10");
        }
        cont--;

        int a = 0;
        for (QualAnalytics c : lcUse) {
            a++;
            if (a <= aux)
                lcUse2.add(c);
        }
       
        mv.addObject("campos", lcUse);
        return mv;
    }

    @RequestMapping(value = "/analytics_list_url", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping
    public Analytic getAnalytics_list_Url() {

        return new Analytic();
    }

    @RequestMapping(value = "/user_url", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping
    public ModelAndView getUserUrl() {

        ModelAndView mv = new ModelAndView("user.html");
        List<Campo> lcUser = getJson().getJson_params_url();
        List<Campo> lcUser1 = new ArrayList<>();
        List<Campo> lcUser2 = new ArrayList<>();

        ConfigActivityDao cd = new ConfigActivityDao();
        ConfigActivity configActivity = cd.getActivity(lcUser.size());
        int a = 0;
        for (Campo c : lcUser) {
            if (!c.isAnswer()) {
                a++;

                if (a == 2)
                    c.setLabel(configActivity.getQuestao1() + "(S/N)");
                if (a == 3)
                    c.setLabel(configActivity.getQuestao2() + "(S/N)");
                if (a == 4)
                    c.setLabel(configActivity.getQuestao3() + "(S/N)");
                if (a == 5)
                    c.setLabel(configActivity.getQuestao4() + "(S/N)");
                if (a == 6)
                    c.setLabel(configActivity.getQuestao5() + "(S/N)");
                if (a == 7)
                    c.setLabel(configActivity.getQuestao6() + "(S/N)");
                if (a == 8)
                    c.setLabel(configActivity.getQuestao7() + "(S/N)");
                if (a == 9)
                    c.setLabel(configActivity.getQuestao8() + "(S/N)");
                if (a == 10)
                    c.setLabel(configActivity.getQuestao9() + "(S/N)");
                if (a == 11)
                    c.setLabel(configActivity.getQuestao10() + "(S/N)");

                lcUser1.add(c);
            }
        }
        // System.out.println("======================>"lcUser1.size());
        lcUser2.add(lcUser1.get(0));
        lcUser1.remove(0);
        mv.addObject("campos", lcUser1);
        mv.addObject("campos2", lcUser2);
        mv.addObject("link", configActivity.getUrlpdf());
        String titulo = getJson().getName();
        mv.addObject("name", titulo);
        System.out.println(cd.getActivity(lcUser.size()).toString());

        return mv;
    }

    @RequestMapping(value = "/registry_url", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping
    public Registry getJson() {
        Registry r = Registry.getSingle_instance();
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<Registry> typeReference = new TypeReference<Registry>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/registo.json");
        try {
            r = mapper.readValue(inputStream, typeReference);
            ;

        } catch (IOException e) {
            System.out.println("Unable to read JSON registry file: " + e.getMessage());
        }

        return r;
    }

    public Registry getJsonAndCreateDataBase() {
        Registry r = Registry.getSingle_instance();
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<Registry> typeReference = new TypeReference<Registry>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/registo.json");
        try {
            r = mapper.readValue(inputStream, typeReference);
            ;

        } catch (IOException e) {
            System.out.println("Unable to read JSON registry file: " + e.getMessage());
        }

        ConfigActivityDao configActivityDao = new ConfigActivityDao();
        configActivityDao.dropActivityTable();
        configActivityDao.createActivityTable();
        configActivityDao.updateTable(r);

        return r;
    }

    @RequestMapping(value = "/save_User_Read_Pdf", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping
    public String getSolveActivity0(HttpSession session) {

        int numeroEstudante = (int) session.getAttribute("numero");
        QualAnalyticsDao qd = new QualAnalyticsDao();
        qd.saveUrlstatus(numeroEstudante, 1);

        return "Actividade registada com sucesso";
    }

    @RequestMapping(value = "/save_User_Answers", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping
    public String getSolveActivity1(@ModelAttribute Answer answer, HttpSession session) {

        List<Campo> lcUser = getJson().getJson_params_url();
        int numeroEstudante = (int) session.getAttribute("numero");
        QualAnalyticsDao qd = new QualAnalyticsDao();
        int rStatus = 0;
        System.out.println(answer.getQuestao1());
        System.out.println(answer.getQuestao2());
        System.out.println(answer.getQuestao3());

        ConfigActivityDao cd = new ConfigActivityDao();
        ConfigActivity configActivity = cd.getActivity(lcUser.size());

        int cont = configActivity.getNumberQuestions();
        System.out.println(answer.getQuestao1() + "<====>" + configActivity.getQuestao1status());
        if (cont > 0) {
            if (answer.getQuestao1().equalsIgnoreCase(configActivity.getQuestao1status())) {
                rStatus = 1;
                qd.saveQ1status(numeroEstudante, rStatus);

                rStatus = 0;
            }
        }
        cont--;
        if (cont > 0) {
            if (answer.getQuestao2().equalsIgnoreCase(configActivity.getQuestao2status())) {
                rStatus = 1;
                qd.saveQ2status(numeroEstudante, rStatus);
                rStatus = 0;
            }
        }

        cont--;
        if (cont > 0) {
            if (answer.getQuestao3().equalsIgnoreCase(configActivity.getQuestao3status())) {
                rStatus = 1;
                qd.saveQ3status(numeroEstudante, rStatus);
                rStatus = 0;
            }
        }

        cont--;
        if (cont > 0) {
            if (answer.getQuestao4().equalsIgnoreCase(configActivity.getQuestao4status())) {
                rStatus = 1;
                qd.saveQ4status(numeroEstudante, rStatus);
                rStatus = 0;
            }
        }

        cont--;
        if (cont > 0) {
            if (answer.getQuestao5().equalsIgnoreCase(configActivity.getQuestao5status())) {
                rStatus = 1;
                qd.saveQ5status(numeroEstudante, rStatus);
                rStatus = 0;
            }
        }

        cont--;
        if (cont > 0) {
            if (answer.getQuestao6().equalsIgnoreCase(configActivity.getQuestao6status())) {
                rStatus = 1;
                qd.saveQ6status(numeroEstudante, rStatus);
                rStatus = 0;
            }
        }

        cont--;
        if (cont > 0) {
            if (answer.getQuestao7().equalsIgnoreCase(configActivity.getQuestao7status())) {
                rStatus = 1;
                qd.saveQ7status(numeroEstudante, rStatus);
                rStatus = 0;
            }
        }

        cont--;
        if (cont > 0) {
            if (answer.getQuestao8().equalsIgnoreCase(configActivity.getQuestao8status())) {
                rStatus = 1;
                qd.saveQ8status(numeroEstudante, rStatus);
                rStatus = 0;
            }
        }

        cont--;
        if (cont > 0) {
            if (answer.getQuestao9().equalsIgnoreCase(configActivity.getQuestao9status())) {
                rStatus = 1;
                qd.saveQ9status(numeroEstudante, rStatus);
                rStatus = 0;
            }
        }

        cont--;
        if (cont > 0) {
            if (answer.getQuestao10().equalsIgnoreCase(configActivity.getQuestao10status())) {
                rStatus = 1;
                qd.saveQ10status(numeroEstudante, rStatus);
                rStatus = 0;
            }
        }

        return "Actividade registada com sucesso";
    }

   
    @GetMapping(value = "/login")
    public ModelAndView getLogin(@ModelAttribute Answer answer, HttpSession session, ModelAndView model) {
        
        session.setAttribute("numero", answer.getIdu());
        UserDao ud = new UserDao();
        int checkNumber = ud.login(answer.getIdu());
        if (checkNumber == 0)
            return index("Login Error");
        else
            return index("Login Sucessfull!");
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    @GetMapping
    public ModelAndView getHome(@ModelAttribute Answer answer, HttpSession session, ModelAndView model) {
        
        
            return index("Form saved successfully");
    }

    @GetMapping(value = "/logout")
    public ModelAndView getLogOut(@ModelAttribute Answer answer, HttpSession session, ModelAndView model) {
        
        session.removeAttribute("name");
        return index("Please Log in");
        
    }


    @RequestMapping(value = "/qual", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping
    public ModelAndView getQual() {

        ModelAndView mv = new ModelAndView("qualAnalyticList.html");
        List<Analytica> lcUser = getJson().getQualAnalytics();
        
        
        mv.addObject("analytics", lcUser);
        
        String titulo = getJson().getName();
        mv.addObject("name", titulo);

        return mv;
    }

}
