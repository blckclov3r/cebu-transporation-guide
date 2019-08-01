package com.blckclov3r.cebu_mproject.mMainActivity;

import android.content.Context;

import com.blckclov3r.cebu_mproject.mDatabase.DBHelper;
import com.blckclov3r.cebu_mproject.mModel.Jeepcode;

public class RouteList {
    private static RouteList obj = null;
    DBHelper dbHelper;
    Context context;

    private RouteList() {
    }

    public static RouteList getInstance() {
        if (obj == null) {
            obj = new RouteList();
        }
        return obj;
    }

    public void display(Context context) {
        this.context = context;
        dbHelper = new DBHelper(context);
        dbHelper.jeepCodeData(new Jeepcode("01B", "* Sambag 1 to Pier 3 & 2 via Colon St.\n" +
                "(PRIVATE TO COLON) \n" +
                "- Sambag 1 \n" +
                "- University of San Carlos (South Campus) \n" +
                "- Private \n" +
                "- J. Alcantara St. \n" +
                "- Asian College of Technology \n" +
                "- E Mall - Leaon Kilat St. \n" +
                "- Gaisano Capital South \n" +
                "- Colon St. \n" +
                "- Metro Colon \n" +
                "- Colonnade Mall \n" +
                "- University of the Visayas \n" +
                "- Gaisano Main \n" +
                "- Colon Obelisk \n" +
                "- Mabini St. \n" +
                "- Sandiego-Yap Ancestral House \n" +
                "- Brgy. Parian \n" +
                "- A. Bonifacio St. \n" +
                "- D. Jakosalem St. \n" +
                "- P. del Rosario St. \n" +
                "- T. Padilla St. \n" +
                "- Pier 4 \n" +
                "- Sergio Osmena Blvd. \n" +
                "- V. Sotto St. \n" +
                "- Pier 3 \n" +
                "- Cebu Mactan Ferry Terminal \n" +
                "- C. Arellano Blvd. \n" +
                "- Pier 2.\n" +
                "\t\n" +
                "\t\n" +
                "* Pier 2 & 3 to Sambag 1 (PRIVATE)\n" +
                "- Pier 2 \n" +
                "- C. Arellano St. \n" +
                "- Pier 3 \n" +
                "- Cebu-Mactan Ferry Terminal \n" +
                "- V. Sotto St. \n" +
                "- Sergio Osmena Blvd. \n" +
                "- Pier 4 \n" +
                "- T. Padilla St. \n" +
                "- Sikatuna St. \n" +
                "- Brgy. Parian \n" +
                "- J.C. Zamora St. \n" +
                "- Sanciangko St. \n" +
                "- University of the Visayas \n" +
                "- Sogo Hotel \n" +
                "- GV Tower Hotel \n" +
                "- University of Cebu (Main Campus) \n" +
                "- Leon Kilat St. \n" +
                "- E Mall \n" +
                "- Asian College of Technology \n" +
                "- J. Alcantara St. \n" +
                "- Private \n" +
                "- University of San Carlos (South Campus) - Sambag 1.", "Pier 2 & 3 to Sambag 1 | Pier 2 & 3 to Sambag 1 (PRIVATE)"));

        dbHelper.jeepCodeData(new Jeepcode("01K", "- Urgello St. \n" +
                "- Sacred Heart Hospital \n" +
                "- South Western University \n" +
                "- E. Mall \n" +
                "- L. Kilat St. \n" +
                "- Colon St. Metro Gaisano (colon) \n" +
                "- Collonade Supermarket \n" +
                "- University of the Visayas \n" +
                "- Gaisano Main - Brgy. Parian \n" +
                "- Zulueta St. - MJ. Cuenco Ave. \n" +
                "- NSO \n" +
                "- General Maxilom Ave. \n" +
                "- A. Soriano Ave. \n" +
                "- SM \n" +
                "- SM Hypermarket \n" +
                "- North Bus Terminal \n" +
                "- Cebu Doctor's University \n" +
                "- CICC \n" +
                "- Parkmall PUJ Terminal \n" +
                "- Parkmall \n" +
                "- MO2 \n" +
                "- North Bus Terminal \n" +
                "- SM Hypermarket \n" +
                "- SM City Cebu \n" +
                "- White Gold Club \n" +
                "- Queen City Memorial Garden \n" +
                "- White Gold House \n" +
                "- T. Padilla St. \n" +
                "- NSO \n" +
                "- CITU \n" +
                "- V. Gullas St. \n" +
                "- Manalili St. \n" +
                "- Legaspit St. \n" +
                "- Collonade Supermarket \n" +
                "- Pelaez St. \n" +
                "- Sancianko St. \n" +
                "- Sogo HOtel \n" +
                "- GV Tower Hotel \n" +
                "- E.Mall \n" +
                "- Urgello St. \n" +
                "- South Western University \n" +
                "- Sacred Heart Hospital", "Parkmall to Urgello | Urgello to Parkmall"));

        dbHelper.jeepCodeData(new Jeepcode("02B", "- CCMC \n" +
                "- N. Bacalso Ave. \n" +
                "- Cebu South Bus Terminal \n" +
                "- E Mall \n" +
                "- L. Kilat St. \n" +
                "- Colon St. \n" +
                "- Metro Gaisano Colon \n" +
                "- Colonnade Supermarket \n" +
                "- Gaisano Main \n" +
                "- University of the Visayas \n" +
                "- P. Burgos St. \n" +
                "- Cebu Metropolitan Cathedral \n" +
                "- F. Urdanet St. \n" +
                "- Legaspi Ext. \n" +
                "- Plaza Independencia \n" +
                "- C. Arellano Blvd. \n" +
                "- Pier 1 \n" +
                "- Pier 2 \n" +
                "- Pier 3 \n" +
                "\n" +
                "- Pier 3\n" +
                "- V. Sotto St. \n" +
                "- Sergio Osmena Blvd. \n" +
                "- Pier 4 \n" +
                "- Pier 5 \n" +
                "- Robinson Mall \n" +
                "- Gen. Maxilom Ave. Ext. \n" +
                "- White Gold House \n" +
                "- Cebu City Health Center \n" +
                "- Bueareau of Quarantin \n" +
                "- Cebu City Civil Registrars \n" +
                "- Cebu Skin Clinic \n" +
                "- Imus Ave. \n" +
                "- MJ. Cuenco Ave. \n" +
                "- Museo Sugbo \n" +
                "- CPILS \n" +
                "- A. Bonifacio St. \n" +
                "- Sikatuna St. \n" +
                "- JC. Zamora St. \n" +
                "- Sancianko St. \n" +
                "- University of the Visayas \n" +
                "- Sogo Hotel \n" +
                "- GV Tower Hotel \n" +
                "- University of Cebu \n" +
                "- Elizabeth Mall \n" +
                "- Panganiban St. \n" +
                "- Cebu City Medical Center.", "South Bus Terminal to Pier | Pier to Cebu South Bus Terminal"));

        dbHelper.jeepCodeData(new Jeepcode("03A", "* Mabolo (Panagdait) to Carbon\n" +
                "- Cityscape Hotel \n" +
                "- Brgy, Kasambagan \n" +
                "- F. Cabahug St. \n" +
                "- Panagdait \n" +
                "- Sykes Asia \n" +
                "- Synergis Center \n" +
                "- Rainforest Park \n" +
                "- Citi Park Hotel \n" +
                "- Fooda (Kasambagan) \n" +
                "- Sarrosa International Hotel \n" +
                "- Castle Peak Hotel \n" +
                "- Pope John Paul II Ave. \n" +
                "- PLDT Smart Communications \n" +
                "- Camelite Monastery \n" +
                "- Mabolo Church \n" +
                "- MJ. Cuenco Ave. \n" +
                "- The Persimmon \n" +
                "- Hipodromo \n" +
                "- Carreta Cemetery \n" +
                "- Imus Ave. \n" +
                "- MJ. Cuenco ave. \n" +
                "- Museo Sugbo \n" +
                "- CPILS \n" +
                "- NSO \n" +
                "- Cebu Technological University \n" +
                "- V. Gullas St. \n" +
                "- Gaisano Main \n" +
                "- Manalili St. \n" +
                "- Colonnade Supermarket \n" +
                "- Progreso St. \n" +
                "- Carbon Public Market. \n" +
                "\t\n" +
                "\n" +
                "* Carbon to Mabolo (Panagdait) \n" +
                "- Carbon Public Market \n" +
                "- MC. Briones St. \n" +
                "- Senior Citizens Plaza \n" +
                "- Cebu City Hall \n" +
                "- Basilica del Sto. Nino \n" +
                "- La Nueva Supermarket \n" +
                "- Prince warehouse (city Hall) \n" +
                "- Lapulapu St. \n" +
                "- MCWD \n" +
                "- DFA \n" +
                "- COMELEC \n" +
                "- DTI \n" +
                "- Urdaneta St. \n" +
                "- MJ. Cuenco ave. \n" +
                "- CTU \n" +
                "- Commission on Audit \n" +
                "- NSO - Martires \n" +
                "- CPILS \n" +
                "- Museo Sugbo \n" +
                "- Carreta Cemetery \n" +
                "- Hipodromo \n" +
                "- The Persimmon \n" +
                "- Mabolo Church \n" +
                "- Pope John Paull ll Ave. \n" +
                "- Carmelite Monastery \n" +
                "- PLDT \n" +
                "- F. Cabahug St. \n" +
                "- Brgy. Kasambagan \n" +
                "- Castle Peak Hotel \n" +
                "- Sarrosa International Hotel \n" +
                "- Fooda Kasambagan \n" +
                "- Citi Park Hotel \n" +
                "- Rainforest Park \n" +
                "- Synergis Center \n" +
                "- Sykes Asia (Cebu) \n" +
                "- Panagdait \n" +
                "- Cityscape Hotel.\n", "Panagdait to Carbon | Carbon to Panagdait (Mabolo)"));

        dbHelper.jeepCodeData(new Jeepcode("03B", "* Mabolo to Colon via Jones ave.\n" +
                "- Sindulan \n" +
                "- carwash \n" +
                "- mabolo \n" +
                "- mabolo church \n" +
                "- M.J. Cuenco ave. \n" +
                "- hipodromo \n" +
                "- Carreta cemetery \n" +
                "- G. Maxilom Ave. \n" +
                "- mango ave \n" +
                "- USC (north campus) \n" +
                "- Fooda saversmart \n" +
                "- horizons 101 \n" +
                "- mango square \n" +
                "- national bookstore \n" +
                "- robinsons place \n" +
                "- Fuente osmena circle  \n" +
                "- crown regency hotel \n" +
                "- jones ave. \n" +
                "- osmena boulevard \n" +
                "- abellana sports complex \n" +
                "- CNU \n" +
                "- SSS \n" +
                "- GV tower hotel \n" +
                "- colon st. \n" +
                "- Metro Colon.\n" +
                "\n" +
                "\t\n" +
                "* Colon to Mabolo\n" +
                "- metro colon \n" +
                "- p. lopez st. \n" +
                "- USJR \n" +
                "- Carbon Public Market \n" +
                "- Lincoln St. \n" +
                "- F. Gonzales St. \n" +
                "- M.C. Briones St. \n" +
                "- cebu city hall \n" +
                "- la nueva (sto. nino) \n" +
                "- prince warehouse club \n" +
                "- MCWD - lapu-lapu St. \n" +
                "- dept. of Foreign Affairs \n" +
                "- OWWA \n" +
                "- F. Urdaneta St. \n" +
                "- M.J. Cuenco Ave. \n" +
                "- CTU \n" +
                "- NSO \n" +
                "- CPILS \n" +
                "- Museo Sugbo \n" +
                "- Carreta \n" +
                "- Hipodromo \n" +
                "- Mabolo \n" +
                "- Carwash \n" +
                "- Sindulan.\n", "Mabolo to Colon via Jones ave. | Colon to Mabolo"));

        dbHelper.jeepCodeData(new Jeepcode("03L", "* Cabantan St. \n" +
                "- C. Rosales ave. \n" +
                "- Juan Luna ave. \n" +
                "- M.J. Cuenco Ave. \n" +
                "- Mabolo Church \n" +
                "- Carreta Cemetery \n" +
                "- Imus Ave. \n" +
                "- M.J. Cuenco ave. \n" +
                "- NSO \n" +
                "- CTU \n" +
                "- V. Gullas St. \n" +
                "- Manalili st. \n" +
                "- Progreso St. \n" +
                "- Carbon Public Market. \n" +
                "\n" +
                "\t\n" +
                "* Carbon Public Market \n" +
                "- MC. Briones St. \n" +
                "- Cebu City Hall \n" +
                "- Basilica del Sto. Nino \n" +
                "- Prince Warehouse Club (MC) \n" +
                "- La Nueva Supermart(City Hall) \n" +
                "- Lapulapu St. \n" +
                "- MCWD \n" +
                "- A. Jereza St. \n" +
                "- MJ. Cuenco Ave. \n" +
                "- CTU \n" +
                "- NSO \n" +
                "- CPILS \n" +
                "- Museo Sugbo \n" +
                "- Imus Ave. \n" +
                "- Mj. Cuenco Ave. \n" +
                "- P. Cabantan St. \n" +
                "- Mabolo (Back)", "Mabolo to Carbon | Carbon to Mabolo"));

        dbHelper.jeepCodeData(new Jeepcode("04B", "* Lahug to Carbon\n" +
                "- Camp Lapulapu \n" +
                "- Salinas Drive \n" +
                "- JY Square Mall \n" +
                "- Lahug \n" +
                "- University of the Philippines \n" +
                "- Harolds Hotel \n" +
                "- Escario St. \n" +
                "- Cebu Provincial Capitol \n" +
                "- Osmena Blvd. \n" +
                "- Cebu Doctors University \n" +
                "- Fuente Osmena Circle \n" +
                "- Robinsons Fuente \n" +
                "- Crown Regency Hotel \n" +
                "- Jones Ave. \n" +
                "- SSS \n" +
                "- Metro Colon \n" +
                "- P. Lopez St. \n" +
                "- Magallanes St. \n" +
                "- University of San Jose-Recoletos \n" +
                "- Carbon Public Market \n" +
                "- F. Calderon St. \n" +
                "- Progreso St.\n" +
                "\n" +
                "\t\n" +
                "* Carbon to Lahug via Osmena Blvd.\n" +
                "- Carbon \n" +
                "- MC. Briones St. \n" +
                "- Cebu City Hall \n" +
                "- Basilica del sto.nino \n" +
                "- La Nueva Supermarket (city hall) \n" +
                "- Lapulapu St. \n" +
                "- MCWD \n" +
                "- Legaspit St. \n" +
                "- Colonnade Supermarket \n" +
                "- Pelaez St. \n" +
                "- Hotel de Mercedez \n" +
                "- University of San Carlos Main \n" +
                "- Sto. Rosario Church \n" +
                "- Central Bank of the Philippines \n" +
                "- Osmena Blvd. \n" +
                "- Cebu Normal University \n" +
                "- Abellana Sports Complex \n" +
                "- Crown Regency Hotel \n" +
                "- Robinsons Place Cebu fuente \n" +
                "- Fuente Osmena Circle \n" +
                "- Osmena Blvd. \n" +
                "- Cebu Doctors University \n" +
                "- Cebu Provincial Capitol \n" +
                "- Escario St. \n" +
                "- Golden peak hotel \n" +
                "- Philhealth \n" +
                "- Gorordo Ave. \n" +
                "- Tonros Apartelle \n" +
                "- Harolds Hotel \n" +
                "-  Handuraw Pizza Lahug \n" +
                "- University of the Philippines \n" +
                "- Jy Square Mall \n" +
                "- Salinas Drive \n" +
                "- Camp Lapu lapu.", "Lahug (Campo) to Carbon | Carbon to Lahug (Campo)"));

        dbHelper.jeepCodeData(new Jeepcode("04D", "* PLAZA HOUSING TO CARBON\n" +
                "- Plaza Housing (Busay) \n" +
                "- Cebu Transcentral Highway \n" +
                "- Cebu Veterans Drive \n" +
                "- Marco Polo Hotel \n" +
                "- Jy Square Mall \n" +
                "- Gorordo Ave. \n" +
                "- Lahug \n" +
                "- UP Lahug \n" +
                "- Harolds Hotel \n" +
                "- Morales St. \n" +
                "- Escario St. \n" +
                "- Cebu Provincial Capitol \n" +
                "- S. Osmena Blvd. \n" +
                "- Cebu Doctors University \n" +
                "- Fuente Osmena Circle \n" +
                "- Robinsons Fuente Cebu \n" +
                "- JOnes Ave. \n" +
                "- Abellana Sports Complex \n" +
                "- Cebu NOrmal University \n" +
                "- SSS \n" +
                "- Sancianko ST. \n" +
                "- UC Main \n" +
                "- E. Mall \n" +
                "- Taboan PUblic Market \n" +
                "- Lakandula St. \n" +
                "- Tupas St. \n" +
                "- Magallanes St. \n" +
                "- Carbon Public Market \n" +
                "- Basilica del Sto. Nino \n" +
                "- Cebu City hall . \n" +
                "\t\n" +
                "\n" +
                "* CARBON TO PLAZA HOUSING\n" +
                "- Carbon \n" +
                "- Cebu City Hall \n" +
                "- Mc. Briones St. \n" +
                "- MJ. Cuenco Ave. \n" +
                "- Osmena Blvd. \n" +
                "- Lapulapu St. \n" +
                "- Legaspi St. \n" +
                "- Cathedral \n" +
                "- Colonnade Supermarket \n" +
                "- Pelaez St. \n" +
                "- Cebu Century Hotel \n" +
                "- Hotel de Mercedez \n" +
                "- Sto Rosario Church \n" +
                "- University of San Carlos Main \n" +
                "- Osmena Blvd. \n" +
                "- Central Bank of the Philippines \n" +
                "- Cebu Normal University \n" +
                "- Abellane Sports Center \n" +
                "- Crown Regency HOtel and Suites \n" +
                "- Robinsons Fuente Cebu \n" +
                "- Fuente Osmena Circle \n" +
                "- osmena Blvd \n" +
                "- Cebu Provincial Capitol \n" +
                "- Escario St. \n" +
                "- Gorordo Ave. \n" +
                "- UP Lahug \n" +
                "- JY Square Mall \n" +
                "- Cebu Veterans Drive \n" +
                "- Marco Polo HOtel \n" +
                "- dcebu Transcentral HIghway \n" +
                "- Busay \n" +
                "- Plaza Housing", "Plaza Housing to Carbon | Carbon to Plaza Housing"));

        dbHelper.jeepCodeData(new Jeepcode("04i", "* BUSAY(plaza housing) to CARBON\n" +
                "- Busay \n" +
                "- Plaza Housing \n" +
                "- Trancentral Highway \n" +
                "- Cebu Veterans Drive \n" +
                "- Marco Polo Hotel \n" +
                "- Jy Square Mall \n" +
                "- Gorordo Ave. \n" +
                "- Lahug \n" +
                "- UP(lahug) \n" +
                "- Harolds Hotel \n" +
                "- Golden Peak Hotel \n" +
                "- Philhealth \n" +
                "- Royal Concourse \n" +
                "- Perpetual Soccor \n" +
                "- Asilo dela Milagrosa \n" +
                "- Mango Ave. \n" +
                "- Gen. Maxilom Ave. \n" +
                "- Fooda Mango \n" +
                "- Horizon 101 \n" +
                "- Robinsons Place (fuente) \n" +
                "- F. Ramos St. \n" +
                "- Junquera ext. \n" +
                "- Junquera St. \n" +
                "- Sancianko St. \n" +
                "- elizabeth Mall \n" +
                "- Panganbiban ST. \n" +
                "- Magallanes St. \n" +
                "- Usjr \n" +
                "- Manalili St. \n" +
                "- Carbon Public Market \n" +
                "- Progresso St. \n" +
                "\t\n" +
                "\n" +
                "*CARBON TO BUSAY(plaza housing)\n" +
                "- Carbon \n" +
                "- M.C. Briones St. \n" +
                "- Cebu City Hall \n" +
                "- La Nueva Supermart (city hall) \n" +
                "- Prince Warehouse Club (city hall) \n" +
                "- Basilica del Sto. Nino \n" +
                "- Lapu-lapu St.\n" +
                "- Legaspi St. \n" +
                "- Cebu Metropolitan Cathedral \n" +
                "- D. Jakosalem St. \n" +
                "- Gaisano Main \n" +
                "- University of the Visayas \n" +
                "- Cogon Ramos \n" +
                "- Echavez Ext. \n" +
                "- F. Ramos St. \n" +
                "- Robinsons Place \n" +
                "- Mango ave. \n" +
                "- Gen. Maxilom Ave. \n" +
                "- One Mango Ave. \n" +
                "- The Beat \n" +
                "- Horizons 101 \n" +
                "- Fooaa Mango \n" +
                "- Gorordo Ave. \n" +
                "- Royal Concourse \n" +
                "- Golden Peak Hotel \n" +
                "- Philhealth \n" +
                "- Harolds Hotel \n" +
                "- UP(cebu) \n" +
                "- Lahug \n" +
                "- JY square Mall \n" +
                "- Cebu Veterans Drive \n" +
                "- Marco Polo \n" +
                "- Cebu Transcentral Highway \n" +
                "- Plaza Housing \n" +
                "- Busay", "Busay (plaza housing) to Carbon | Carbon to Busay (plaza housing)"));

        dbHelper.jeepCodeData(new Jeepcode("04L", "* Lahug to Sm via Ayala\n" +
                "- Lahug \n" +
                "- JY Square Mall \n" +
                "- Gorordo Ave. \n" +
                "- corner Sudlon \n" +
                "- Corner Beverly Hills \n" +
                "- Corner Dep-ed (ecotech) \n" +
                "- Lahug Brgy Hall \n" +
                "- University of the Philippines (Cebu) \n" +
                "- Sugbo Cultural Center \n" +
                "- Harolds Hotel \n" +
                "- Tonross Apartelle \n" +
                "- The Golden Peak Hotel  \n" +
                "- N. Escario Hotel \n" +
                "-  Philhealth \n" +
                "- Kuya J's Restaurant \n" +
                "- Cebu Parklane Hotel \n" +
                "- Grand Cenia Hotel \n" +
                "- Hongkong Plaza Hotel \n" +
                "- Cebu Business Park \n" +
                "- Mindanao Ave. \n" +
                "- Pag-ibig Fund \n" +
                "- Ayala Center Cebu \n" +
                "- Cardinal Rosales Ave. \n" +
                "- Pope John Paul ll Ave. \n" +
                "- PLDT \n" +
                "- Carmelite Monastery \n" +
                "- St. Joseph Parish (Mabolo Church) \n" +
                "- Sm City Cebu.\n" +
                "\t\n\n" +
                "* Sm to Lahug\n" +
                "- Sm City Cebu \n" +
                "- Radisson Hotel \n" +
                "- Sergio Osmena Blvd. \n" +
                "- Kaohsiung St. \n" +
                "- Cebu Daily News \n" +
                "- A. Soriano Ave. \n" +
                "- Juan Luna Ave. ext. \n" +
                "- Pope John Paul ll Ave. \n" +
                "- Mabolo Church \n" +
                "- Andoks Mabolo \n" +
                "- Carmelite Monastery \n" +
                "- San Carlos Seminary College \n" +
                "- TESDA Vll - Salinas Drive \n" +
                "- Cebu IT Park \n" +
                "- Waterfront Hotel \n" +
                "- Crowne Garden Hotel \n" +
                "- Jy Square Mall \n" +
                "- Lahug.", "Lahug to Sm via Ayala | Sm to Lahug"));

        dbHelper.jeepCodeData(new Jeepcode("04M", "* Ayala Terminal to Lahug (JY Square Mall)\n" +
                "- Ayala Terminal \n" +
                "- Gorordo Ave. \n" +
                "- Royal Concourse \n" +
                "- Philhealth \n" +
                "- Golden peak Hotel \n" +
                "- UP (lahug) \n" +
                "- Lahug Brgy. Hall \n" +
                "- Corner Sudlon \n" +
                "- Jy Square Mall.\n" +
                "\t\n" +
                "\n" +
                "* Lahug (JY Square Mall) to Ayala Terminal\n" +
                "- Jy Square Mall \n" +
                "- Salinas Drive \n" +
                "- USP - IT Park \n" +
                "- Waterfront Hotel \n" +
                "- Arch. Reyes Ave. \n" +
                "- Ayala Terminal.", "Ayala Terminal to Lahug (JY Square Mall) | " +
                "Lahug (JY Square Mall) to Ayala Terminal"));

        dbHelper.jeepCodeData(new Jeepcode("04H", "* Plaza Housing to Carbon via Jones Ave.\n" +
                "- Plaza Housing (Busay) \n" +
                "- Cebu Transcentral Highway \n" +
                "- Cebu Veterans Drive \n" +
                "- Marco Polo Plaza Hotel \n" +
                "- Lahug \n" +
                "- Jy Square Mall \n" +
                "- Gorordo Ave. \n" +
                "- Dep-ed \n" +
                "- Beverly Hills \n" +
                "- Lahug Elem. School \n" +
                "- Sugbo Cultural Center \n" +
                "- University of the Philippines (Cebu) \n" +
                "- Harolds Hotel \n" +
                "- Molave St. \n" +
                "- Morales St. \n" +
                "- N. Escario St. \n" +
                "- Our Lady of Sacred Heart Parish \n" +
                "- Capitol Tourist Inn \n" +
                "- Cebu Pension Plaza \n" +
                "- The Maxwell Hotel \n" +
                "- Escario Central \n" +
                "- Cebu Provincial Capitol \n" +
                "- Osmena Blvd (Jones Ave.) \n" +
                "- Cebu Doctors Hospital \n" +
                "- Fuente Osmena Circle \n" +
                "- Robinsons Fuente \n" +
                "- Crown Regency Hotel \n" +
                "- Visayas Community Medical Center \n" +
                "- Harrison Park \n" +
                "- Cebu City Sports Center(Abellana) \n" +
                "- Cebu Normal University \n" +
                "- GV Tower Hotel \n" +
                "- Sanciangko St. \n" +
                "- Elizabeth Mall \n" +
                "- New Cebu Coliseum \n" +
                "- Panganiban St. \n" +
                "- Magallanes St. \n" +
                "- University of San Jose Recoletos \n" +
                "- Carbon Public Market \n" +
                "- Escano St. \n" +
                "- El Filibusterismo St. \n" +
                "- Progreso St. \n" +
                "\t\n" +
                "* Carbon to Plaza Housing\n" +
                "- Carbon Public Market \n" +
                "- MC. Briones St. \n" +
                "- Cebu City Hall \n" +
                "- La Nueva Supermarket(City Hall) \n" +
                "- Basilica del Sto. Nino \n" +
                "- Lapulapu St. \n" +
                "- MCWD \n" +
                "- DFA \n" +
                "- Legaspi St. \n" +
                "- Cebu Metropolitan Cathedral \n" +
                "- Cebu Eastern College \n" +
                "- Colonnade Supermarket \n" +
                "- Pelaez St. \n" +
                "- Hotel de Mercedes \n" +
                "- P. del Rosario St. \n" +
                "- University of San Carlos(Main) \n" +
                "- Osmena Blvd.(Jones Ave.) \n" +
                "- Cebu City Sports Center(Abellana) \n" +
                "- Cebu Normal University \n" +
                "- Visayas Community Medical Center \n" +
                "- Crown Regency Hotel \n" +
                "- Robinsons Place Cebu(fuente) \n" +
                "- Fuente Osmena Circle \n" +
                "- Cebu Doctors Hospital \n" +
                "- Cebu Provincial Capitol \n" +
                "- N. Escario St. \n" +
                "- Capitol Tourist Inn \n" +
                "- Our Lady of Sacred Heart Parish \n" +
                "- Golden Peak Hotel \n" +
                "- PHILHEALTH \n" +
                "- Gorordo Ave. \n" +
                "- Harolds Hotel \n" +
                "- University of the Philippines(Cebu) \n" +
                "- Sugbo Cultural Center \n" +
                "- Lahug Elem. School \n" +
                "- Dep-ed \n" +
                "- Beverly Hills \n" +
                "- Lahug \n" +
                "- Jy Square Mall \n" +
                "- Cebu Veterans Drive \n" +
                "- Marco Polo Plaza Hotel \n" +
                "- Cebu Transcentral Highway \n" +
                "- Busay \n" +
                "- Plaza Housing", "Plaza Housing to Carbon via Jones Ave. | " +
                "Carbon to Plaza Housing"));
        dbHelper.jeepCodeData(new Jeepcode("06B", "* Guadalupe Church \n" +
                "- Fooda (guadalupe)\n" +
                "- PRC \n" +
                "- M. Velez St. \n" +
                "- Provincial Capitol \n" +
                "- Jones Ave. \n" +
                "- Fuente Osmena Circle \n" +
                "- Robinsons Place \n" +
                "- Crown Regency Hotel \n" +
                "- Osmena Blvd. \n" +
                "- Abellana Sports Complex \n" +
                "- Metro Gaisano \n" +
                "- USJR \n" +
                "- Carbon Public Market \n" +
                "- Cebu City Hall \n" +
                "- Basilica Menore del Snr. Snto. Nino \n" +
                "- Osmena Blvd.\n" +
                "\n" +
                "\n" +
                "* Osmena Blvd. \n" +
                "- Basilica del sto. Nino \n" +
                "- Metro Gaisano (colon) \n" +
                "- Abellana Sports Complex \n" +
                "- Cebu Normal University \n" +
                "- Crown Regency Hotel \n" +
                "- Robinsons Place Cebu \n" +
                "- Fuente Osmena Circle \n" +
                "- Cebu Doctors University \n" +
                "- Provincial Capitol \n" +
                "- M. Velez St. \n" +
                "- PRC \n" +
                "- Fooda (guadalupe) \n" +
                "- Guadalupe Church", "Guadalupe Church to Osmena Blvd. | Osmena Blvd " +
                "to Guadalupe Church"));

        dbHelper.jeepCodeData(new Jeepcode("06C", "* Guadalupe to Colon\n" +
                "- Guadalupe church \n" +
                "- Fooda Guadalupe \n" +
                "- PRC - V. Rama Ave. \n" +
                "- B. Rodriguez St. \n" +
                "- Vicente Sotto Hospital \n" +
                "- Fuente Osmena Circle \n" +
                "- Robinsons Place \n" +
                "- Crown Regency Hotel \n" +
                "- Osmena Blvd. \n" +
                "- Abellana Sports Center \n" +
                "- Cebu Normal University \n" +
                "- SSS \n" +
                "- Metro Gaisano \n" +
                "- Plaridel St. \n" +
                "- MC. Briones St. \n" +
                "- Cebu City Hall \n" +
                "- Basilica Menore del Santo Nino \n" +
                "- La Nueva \n" +
                "- MCWD \n" +
                "- Osmena Blvd.\n" +
                "\t\n" +
                "\t\n" +
                "* Colon to Guadalupe\n" +
                "- Osmena Blvd. \n" +
                "- Basilica Menore del Santo Nino \n" +
                "- Metro Gaisano \n" +
                "- Colon \n" +
                "- Jones Ave. \n" +
                "- Abellana Sports Center \n" +
                "- Cebu Normal University \n" +
                "- Crown Regency Hotel \n" +
                "- Fuente Osmena Circle \n" +
                "- Robinsons Place \n" +
                "- B. Rodriguez St. \n" +
                "- Vicente Sotto Hospital \n" +
                "- V. Rama Ave. \n" +
                "- PRC \n" +
                "- Fooda (guadalupe) \n" +
                "- Guadalupe Church.", "Guadalupe to Colon | Colon to Guadalupe"));

        dbHelper.jeepCodeData(new Jeepcode("06F", "*Guadalupe to Carbon\n" +
                "- Guadalupe Church \n" +
                "- V. Rama Ave. \n" +
                "- Fooda Saversmart \n" +
                "- Guadalupe Brgy. Hall \n" +
                "- PRC \n" +
                "- R. Duterte St. \n" +
                "- M. Velez St. \n" +
                "- Don Gil Garcia St. \n" +
                "- Cebu Provincial Capitol \n" +
                "- Don Jose Avila St. \n" +
                "- Osmena Blvd.(Jones Ave) \n" +
                "- Cebu Doctors Hospital \n" +
                "- Fuente Osmena Circle \n" +
                "- Robinsons Place Fuente \n" +
                "- Crown Regency Hotel & Suites \n" +
                "- Cebu City Sports Center \n" +
                "- Abellana Sports Complex \n" +
                "- Cebu Normal University \n" +
                "- SSS \n" +
                "- GV Tower Hotel \n" +
                "- Metro Gaisano (Colon) \n" +
                "- Happy Mart \n" +
                "- Plaridel St. \n" +
                "- Carbon Public Market \n" +
                "- Progreso St.\n" +
                "\t\n" +
                "* Carbon to Guadalupe \n" +
                "- Carbon Public Market \n" +
                "- MC. Briones St. \n" +
                "- Cebu City Hall \n" +
                "- Senior Citizens Park \n" +
                "- Basilica del Sto. Nino \n" +
                "- La nueva supermart \n" +
                "- Lapulapu St. \n" +
                "- MCWD - Osmena Blvd. \n" +
                "- Basilica Menore del Sto. Nino \n" +
                "- Metro Gaisano Colon \n" +
                "- La Guardia Hotel \n" +
                "- Central Bank of the Philippines \n" +
                "- Cebu City Sports Center \n" +
                "- Cebu Normal University \n" +
                "- Camp Sergio Osmena \n" +
                "- PLDT \n" +
                "- Crown Regency Hotel \n" +
                "- Robinsons Place Fuente \n" +
                "- Fuente Osmena Circle \n" +
                "- Cebu Doctors Hospital \n" +
                "- Cebu Provincial Capitol \n" +
                "- Escario St. \n" +
                "- Don Gil Garcia St. \n" +
                "- M. Velez St. \n" +
                "- R. Duterte St. \n" +
                "- V. Rama St. \n" +
                "- PRC \n" +
                "- Guadalupe Brgy. Hall \n" +
                "- Fooda Saversmart \n" +
                "- Guadalupe Church", "Guadalupe to Carbon | Carbon to Guadalupe"));

        dbHelper.jeepCodeData(new Jeepcode("06G", "* Guadalupe Church \n" +
                "- V. rama Ave. \n" +
                "- Fooda Saversmart \n" +
                "- PRC - Securities and Exchange Commission \n" +
                "- Calamba Cemetery \n" +
                "- University of San Carlos (girls high school) \n" +
                "- Katipunan st. \n" +
                "- tres de abril st. \n" +
                "- Carlock st. \n" +
                "- San Nicolas Elementary school \n" +
                "- B. aranas St. \n" +
                "- Taboan Public Market \n" +
                "- Pasil Fish Market \n" +
                "- San Nicolas Church \n" +
                "- Carlos Gothong HS \n" +
                "- C. Padilla St. \n" +
                "\n" +
                "\n" +
                "* C. Padilla St. \n" +
                "- R. Padilla st. \n" +
                "- N. Bacalso Hi-way \n" +
                "- Salazar Colleges \n" +
                "- V. rama Ave. \n" +
                "- USC (girls HS) \n" +
                "- Queensland Hotel \n" +
                "- Calamba Cemetery \n" +
                "- Securities and Exchange Commission \n" +
                "- PRC \n" +
                "- Fooda saversmart \n" +
                "- Guadalupe Church\n", "Guadalupe Church to C. Padilla St. | Padilla St. to Guadalupe Church"));

        dbHelper.jeepCodeData(new Jeepcode("06H", "* Guadalupe Church \n" +
                "- V. rama ave. \n" +
                "- crown regency residences \n" +
                "- Fooda Saversmart (guadalupe branch) \n" +
                "- corner banawa \n" +
                "- cebu provincial capitol \n" +
                "- bo's coffee (jones ave.) \n" +
                "- cebu doctors university (jones ave.) \n" +
                "- n. escario st. \n" +
                "- philhealth \n" +
                "- ayala center cebu \n" +
                "- cabantan st. \n" +
                "- juan luna avenue (mabolo) \n" +
                "- mabolo church \n" +
                "- Sm City cebu puj terminal\n" +
                "\n" +
                "* SM terminal \n" +
                "- mabolo church \n" +
                "- ayala center terminal \n" +
                "- asilo \n" +
                "- fooda mango \n" +
                "- mango avenue \n" +
                "- robinsons fuente \n" +
                "- fuente circle \n" +
                "- vicente sotto hospital \n" +
                "- b. rodriguez st. \n" +
                "- v. rama avenue. corner banawa \n" +
                "- PRC (professional regulations commission) \n" +
                "- fooda (guadalupe branch) \n" +
                "- guadalupe church", "Guadalupe Church to SM terminal | " +
                "SM terminal to Guadalupe Church"));

        dbHelper.jeepCodeData(new Jeepcode("07B", "* Banawa \n" +
                "- R. Duterte St. \n" +
                "- V. rama ave. \n" +
                "- B. Rodriguez St. \n" +
                "- Vicente Sotto Hospital \n" +
                "- Fuente Osmena Circle \n" +
                "- Robinsons Fuente \n" +
                "- Crown Regency Hotel \n" +
                "- Osmena Blvd. \n" +
                "- Metro Colon \n" +
                "- P. Lopez St. \n" +
                "- USJR \n" +
                "- Magallanes St. \n" +
                "- Manalili St. \n" +
                "- Carbon Public Market \n" +
                "- Progreso St. \n" +
                "\n" +
                "\t\n" +
                "* Carbon \n" +
                "- M.C. Briones St. \n" +
                "- Mj. Cuenco Ave. \n" +
                "- Osmena Blvd \n" +
                "- Metro Colon \n" +
                "- Abellana Sports Complex \n" +
                "- Jones Ave. \n" +
                "- Cebu Normal University \n" +
                "- Crown Regency Hotel \n" +
                "- Robinsons Fuente \n" +
                "- Fuente Osmena Circle \n" +
                "- Provincial Capitol \n" +
                "- M. Velez St. \n" +
                "- R. Duterte St. \n" +
                "- Rustans (banawa) \n" +
                "- Banawa", "Banawa to Carbon | Carbon to Banawa"));

        dbHelper.jeepCodeData(new Jeepcode("08G", "* Alumnos to Colon via C. Padilla st.\n" +
                "- Alumnos \n" +
                "- Tagunol St. \n" +
                "- UC-METC \n" +
                "- C. Padilla St. \n" +
                "- Jai-alai - Carlock St. \n" +
                "- Spoliarium St. \n" +
                "- Pasil \n" +
                "- San NIcolas Parish \n" +
                "- Colon \n" +
                "- Metro Gaisano \n" +
                "- Colonnade Mall \n" +
                "- Gaisano Main \n" +
                "- University of the Visayas \n" +
                "- Zulueta St.\n" +
                "\t\n" +
                "* COLON TO ALUMNOS\n" +
                "- Zulueta St. \n" +
                "- MJ. Cuenco Ave. \n" +
                "- CTU \n" +
                "- Legaspi St. \n" +
                "- Cebu Metropolitan Cathedral \n" +
                "- V. Gullas St. \n" +
                "- Manalili St. \n" +
                "- Magallanes St. \n" +
                "- USJR \n" +
                "- Carbon Public Market \n" +
                "- C. Padilla St. \n" +
                "- Cacoy Doce Pares \n" +
                "- Jai-alai \n" +
                "- San Roque \n" +
                "- UC-METC \n" +
                "- Mambaling \n" +
                "- Alumnos", "Alumnos to Colon via C. Padilla st. | Colon to Alumnos"));

        dbHelper.jeepCodeData(new Jeepcode("09F", "* Basak-Ibabao (Quiot) to Colon\n" +
                "- Quiot \n" +
                "- Ibabao \n" +
                "- Sabellano St. \n" +
                "- Southwestern University \n" +
                "- Don Vicente Rama Memorial National High School \n" +
                "- Basak \n" +
                "- Mambaling \n" +
                "- Shopwise \n" +
                "- Mambaling Flyover \n" +
                "- CIT \n" +
                "- SCSIT \n" +
                "- Natalio Bacalso Ave. \n" +
                "- E.mall \n" +
                "- ACT \n" +
                "- P. del Rosario \n" +
                "- University of San Carlos \n" +
                "- Junquera St. \n" +
                "- Colon St. \n" +
                "- Gaisano Main \n" +
                "- University of the Visayas \n" +
                "- Zulueta St. -M.J. Cuenco Ave. \n" +
                "- Legaspi St. \n" +
                "- Cebu Metropolitan Cathedral.\n" +
                "\t\n" +
                "\t\n" +
                "* Colon to Basak-Ibabao\n" +
                "- Cebu Metropolitan Cathedral \n" +
                "- Basilica Menore del Santo Nino \n" +
                "- Legaspit St. \n" +
                "- Manalili St. \n" +
                "- Magallanes St. \n" +
                "- University of San Jose Recoletos \n" +
                "- Carbon Public Market \n" +
                "- C. Padilla St. \n" +
                "- Duljo Fatima (R. Padilla St.) \n" +
                "- CIT - N. Bacalso Ave. \n" +
                "- Mambaling Flyover \n" +
                "- Mambaling \n" +
                "- Shopwise \n" +
                "- Basak \n" +
                "- Basak Night High School \n" +
                "- USJR (Hight School) \n" +
                "- Bayanihan Village \n" +
                "- Sabellano St. \n" +
                "- Brgy. Quiot", "Basak-Ibabao (Quiot) to Colon | Colon to Basak-Ibabao"));

        dbHelper.jeepCodeData(new Jeepcode("09G", "* Basak(Ibabao) to Colon \n" +
                "- Basak (Ibabao) \n" +
                "- Hi way \n" +
                "- Shopwise \n" +
                "- Fooda (mambaling) \n" +
                "- Mambaling flyover \n" +
                "- C. Padilla St. \n" +
                "- Carlock St. \n" +
                "- Spoliarium St. \n" +
                "- Pasil \n" +
                "- San Nicolas Parish Church \n" +
                "- Colon St. \n" +
                "- L. Kilat St. \n" +
                "- USJR \n" +
                "- Carbon Public Market \n" +
                "- Magallanes St. \n" +
                "- Basilica Menore Del Sto. Nino \n" +
                "- Cebu City Hall \n" +
                "- MCWD \n" +
                "- Lucky 7 supermarket \n" +
                "- Legaspi St.\n" +
                "\n" +
                "\n" +
                "* Colon to Basak(Ibabao)\n" +
                "- Legaspi St. \n" +
                "- Collonade Mall (Oriente) \n" +
                "- Colon St. \n" +
                "- Metro Gaisano \n" +
                "- C. Padilla St. \n" +
                "- Jai-alai \n" +
                "- Mambling Flyover \n" +
                "- Hi-way \n" +
                "- Mambaling \n" +
                "- Fooda (Mambaling) \n" +
                "- Shopwise \n" +
                "- Basak \n" +
                "- Bayanihan Village \n" +
                "- Sabellano St. \n" +
                "- Brgy. Quiot", "Basak(Ibabao) to Colon | Colon to Basak(Ibabao)"));

        dbHelper.jeepCodeData(new Jeepcode("10F", "* Bulacao \n" +
                "- Pardo \n" +
                "- Basak \n" +
                "- Mambaling \n" +
                "- CIT \n" +
                "- SCSIT \n" +
                "- Cor. V. Rama Ave.\n" +
                "- Citilink Terminal \n" +
                "- CCMC \n" +
                "- Cebu South Bus Terminal \n" +
                "- E.mall \n" +
                "- P.del Rosario St. \n" +
                "- University of San Carlos \n" +
                "- Junquera St.\n" +
                "\n" +
                "\n" +
                "* Junquera St. \n" +
                "- Colon St. \n" +
                "- Metro Gaisano \n" +
                "- Borromeo St. \n" +
                "- Sancianco St. \n" +
                "- Panganiban St. \n" +
                "-  CCMC \n" +
                "- N. Bacalso Ave. (hi-way) \n" +
                "- CIT \n" +
                "- Mambaling \n" +
                "- Fooda (Basak) \n" +
                "- Shopwise \n" +
                "- Basak \n" +
                "- Pardo \n" +
                "- Bulacao", "Bulacao to Junquera St. | Junquera St. to Bulacao"));

        dbHelper.jeepCodeData(new Jeepcode("10G", "* Pardo to Magallanes (Basilica del Sto. Nino)\n" +
                "- Pardo \n" +
                "- Basak \n" +
                "- Shopwise \n" +
                "- Fooda (mambaling) \n" +
                "- Mambaling \n" +
                "- C. Padilla St. \n" +
                "- Jai-alai \n" +
                "- Pasil \n" +
                "- San Nicolas Church \n" +
                "- Colon St. \n" +
                "- L. Kilat St. \n" +
                "- USJR - Carbon Public Market \n" +
                "- Magallanes St. \n" +
                "- Basilica Menore del Santo Nino \n" +
                "- Cebu City Hall \n" +
                "- Prince MC \n" +
                "- La Nueva \n" +
                "- MCWD \n" +
                "- Legaspi St.\n" +
                "\n" +
                "\t\n" +
                "* Magallanes st. to Pardo\n" +
                "- Legaspi St. \n" +
                "- D. Jakosalem St. \n" +
                "- Colon St. \n" +
                "- Gaisano Main \n" +
                "- University of the Visayas \n" +
                "- Colonnade Supermarket \n" +
                "- Metro Gaisano \n" +
                "- C. Padilla St. \n" +
                "- Cebu South Road \n" +
                "- Mambaling \n" +
                "- Fooda (Mambaling) \n" +
                "- Shopwise \n" +
                "- Basak \n" +
                "- Pardo", "Pardo to Magallanes to Pardo | Magallanes to Pardo "));

        dbHelper.jeepCodeData(new Jeepcode("10H", "* From bulacao (Saint Paul College foundation) \n" +
                "- Pardo \n" +
                "- Basak \n" +
                "- mambaling \n" +
                "- CIT \n" +
                "- SCSIT \n" +
                "- Citilink \n" +
                "- CCMC \n" +
                "- Cebu South Bus terminal \n" +
                "- E. mall \n" +
                "- ACT \n" +
                "- P.del Rosario \n" +
                "- Sikatun st. \n" +
                "-  T. padilla st. \n" +
                "- white gold house \n" +
                "- white gold club \n" +
                "- Sm.\n" +
                "\n" +
                "\n" +
                "* SM \n" +
                "- white gold \n" +
                "- cebu city registrars office \n" +
                "- DSWD \n" +
                "- Imus ave. \n" +
                "- M. J. Cuenco Ave. \n" +
                "- cor. t. Padilla St. \n" +
                "- NSO \n" +
                "- Legaspi St. \n" +
                "- Cebu Metropolitan Cathedral \n" +
                "- Manalili st. \n" +
                "- Borromeo St. \n" +
                "- Sancianko st. \n" +
                "- Aerol Pensione House \n" +
                "- CCMC \n" +
                "- N. Bacalso Avenue \n" +
                "- Citilink \n" +
                "- SCSIT \n" +
                "- Napolcom \n" +
                "- CIT \n" +
                "- Mambaling \n" +
                "- Shopwise \n" +
                "- Basak \n" +
                "- Pardo \n" +
                "- Bulacao", "Bulacao to SM | SM to Bulacao"));

        dbHelper.jeepCodeData(new Jeepcode("10M", "* BULACAO TO SM\n" +
                "- Bulcao \n" +
                "- St. Paul College (bulacao) \n" +
                "- Cit Hardware \n" +
                "- Prince Warehouse Club \n" +
                "-  Pardo \n" +
                "- Basak \n" +
                "- USJR (High School) \n" +
                "- Mamabaling \n" +
                "- Shopwise \n" +
                "- Fooda \n" +
                "- Mambaling Flyover \n" +
                "- CIT \n" +
                "- Salazar College \n" +
                "- Napolcom \n" +
                "- CCMC \n" +
                "- Cebu South Bus Terminal \n" +
                "- E mall \n" +
                "- L. Kilat St. \n" +
                "- Colon St. \n" +
                "- Metro Colon \n" +
                "- Colonnade Supermarket \n" +
                "- 138 Mall \n" +
                "- Gaisano Main \n" +
                "- University of the visayas \n" +
                "- Colon Obelisk \n" +
                "- Zulueta St. \n" +
                "- MJ. Cuenco Ave. \n" +
                "- NSO \n" +
                "- T. Padilla St. \n" +
                "- B. Benedicto St. \n" +
                "- White Gold House \n" +
                "- A. Soriano Ave. \n" +
                "- White Gold Club \n" +
                "- Queen City Memorial Garden \n" +
                "- Sm City Cebu (terminal). \n" +
                "\t\n" +
                "\t\n" +
                "* SM TO BULACAO\n" +
                "- Sm Terminal \n" +
                "- A. Soriano Ave. \n" +
                "- White Gold Club \n" +
                "- Queen City Memorial Garden \n" +
                "- Queensland \n" +
                "- White Gold House \n" +
                "- B. Benedecto St. \n" +
                "- T. Padilla St. \n" +
                "- Mj. Cuenco ave. \n" +
                "- NSO \n" +
                "- CTU \n" +
                "- Plaza Independecia \n" +
                "- Legaspi st. \n" +
                "- V. gullas St. \n" +
                "- Manalili St. \n" +
                "- A. Borromeo St. \n" +
                "- Sanciangko St. \n" +
                "- Panganiban st. \n" +
                "- CCMC \n" +
                "- N. Bacalso St. \n" +
                "- Cebu South Road \n" +
                "- CIT \n" +
                "- Mambaling \n" +
                "- Fooda \n" +
                "- Shopwise \n" +
                "- Basak \n" +
                "- Pardo \n" +
                "- Citi Hardware \n" +
                "-  Prince warehouse club \n" +
                "- Bulacao (saint Paul college)", "Bulacao to SM | SM to Bulacao"));

        dbHelper.jeepCodeData(new Jeepcode("11A", "* Inayawan Church \n" +
                "- Rizal Ave. \n" +
                "- Tagunol St. \n" +
                "- Mambaling Flyover \n" +
                "- C. Padilla St. \n" +
                "- Carlock St. \n" +
                "- Spoliarium St. \n" +
                "- Pasil \n" +
                "- San Nicolas Parish \n" +
                "- Magallanes St. \n" +
                "- Basilica Menore del Sto Nino \n" +
                "- D. Jakosalem St. \n" +
                "- Gaisano Main \n" +
                "- University of the Visayas \n" +
                "- Colon St. \n" +
                "\t\n" +
                "\t\n" +
                "* Colon St. \n" +
                "- Gaisano Main \n" +
                "- 138 Mall \n" +
                "- Colonnade Supermarket \n" +
                "- Metro Gaisano \n" +
                "- C. Padilla St. \n" +
                "- Don Carlos Gothong High School \n" +
                "- Jai-alai - Mambaling Flyover \n" +
                "- Tagunol St. \n" +
                "- Rizal Ave. \n" +
                "- Cogon Pardo \n" +
                "- Inayawan Church", "Inayawan to Colon | Colon to Inayawan"));

        dbHelper.jeepCodeData(new Jeepcode("12D", "* LABANGON TO COLON\n" +
                "- Punta Princesa \n" +
                "- F. Llamas St. \n" +
                "- Tisa \n" +
                "- Labangon \n" +
                "- Katipunan St. \n" +
                "- Tres de Abril St. \n" +
                "- N. Bacalso Ave. \n" +
                "- Citilink \n" +
                "- CCMC \n" +
                "- Cebu South Bus Terminal \n" +
                "- E Mall \n" +
                "- ACT \n" +
                "- P. del rosario St. \n" +
                "-  University of San Carlos (main) \n" +
                "- Junquera st. \n" +
                "- Colon st. \n" +
                "- Gaisano Main \n" +
                "- University of the Visayas \n" +
                "- P. Burgos St. \n" +
                "- University of Southern Philippines Foundation \n" +
                "- Cebu Metropolitan Cathedral.\n" +
                "\n" +
                "\t\n" +
                "* Colon to Labangon via Tres de Abril St. \n" +
                "- Cathedral \n" +
                "- Legaspi St. \n" +
                "- Colonnade supermarket \n" +
                "- Pelaez St. \n" +
                "- Sancianko St. \n" +
                "- Sogo Hotel \n" +
                "- GV Tower \n" +
                "- UC \n" +
                "- Leon Kilat St. \n" +
                "- E. Mall \n" +
                "- N. Bacalso Ave. \n" +
                "- South Bus Terminal \n" +
                "- Cebu City Medical Center \n" +
                "- Citilink \n" +
                "- Katipunan st. \n" +
                "- Tres de Abril St. - Punta Princesa", "Labangon to Colon (from Katipunan St.)" +
                "| Colon to Labangon (via Tres de Abril st.)"));


        dbHelper.jeepCodeData(new Jeepcode("12G", "* Sm City Cebu to Labangon via Katipunan St.\n" +
                "- SM City Cebu PUJ Terminal \n" +
                "- J. Luna Ave. \n" +
                "- F. Cabahug St. \n" +
                "- APM Mall \n" +
                "- Cebu Institute Academy \n" +
                "- Sergio Osmena Blvd. \n" +
                "- Cebu Daily News \n" +
                "- Pier 6 \n" +
                "- Sugbutel \n" +
                "- Pier 5 \n" +
                "- PCSO \n" +
                "- Pier 4 \n" +
                "- T. Padilla st. \n" +
                "- Martires \n" +
                "- MJ. Cuenco Ave. \n" +
                "- A. Bonifacio St. \n" +
                "- Sikatuna St. \n" +
                "- Parian Brgy. Hall \n" +
                "- JC. Zamora st. \n" +
                "- Sancianko St. \n" +
                "- University of Cebu \n" +
                "- Sogo Hotel \n" +
                "- GV Tower Hotel \n" +
                "- University of Cebu \n" +
                "- E mall \n" +
                "- Panganiban St. \n" +
                "- CCMC \n" +
                "- N. Bacalso Ave. \n" +
                "- One Citilink Terminal \n" +
                "- Katipunan St. \n" +
                "- Labangon \n" +
                "- F. Llamas st. \n" +
                "- Brgy. Tisa \n" +
                "- Punta Prinsesa \n" +
                "- Tres De Abril st.\n" +
                "\n" +
                "\n" +
                "*Labangon to SM\n" +
                "- Punta Prinsesa \n" +
                "- Tres de Abril St. \n" +
                "- Labangon \n" +
                "- Carlock St. \n" +
                "- B. Aranas St. \n" +
                "- Taboan Public Market \n" +
                "- Lakandula St. \n" +
                "- San Nicolas Parish Church \n" +
                "- Pasil Fish Market \n" +
                "- Spolarium St \n" +
                "- Magallanes St. \n" +
                "- University of  San Jose Recoletos \n" +
                "- Carbon Public market \n" +
                "- Magellans Cross \n" +
                "- Basilica del Sto. Nino \n" +
                "- D. Jakosalem st. \n" +
                "- MC. Briones St. \n" +
                "- Cebu City Hall \n" +
                "- Senior Citizens Park \n" +
                "- La Nueva City Hall \n" +
                "- Plaza Independencia \n" +
                "- MJ. Cuenco ave. \n" +
                "- Legaspi Ext. \n" +
                "- Sergio Osmena Blvd. \n" +
                "- Pier 3 \n" +
                "- Pier 4 \n" +
                "- Sugbutel Bed and Bath \n" +
                "- Pier 5 \n" +
                "- Pier 6 \n" +
                "- Radisson Blu \n" +
                "- Juan Luna Ave. \n" +
                "- SM City Cebu \n" +
                "- Sm Puj Terminal", "Sm City Cebu to Labangon via Katipunan St. | Labangon to SM"));

        dbHelper.jeepCodeData(new Jeepcode("12i", "* SM to Labangon (Tres de Abril St.)\n" +
                "- Sm City Cebu Puj Terminal \n" +
                "- J. Luna Ave. \n" +
                "- F. Cabajug St. \n" +
                "- APM Mall \n" +
                "- Cebu Institute Academy \n" +
                "- Natasha \n" +
                "- S. Osmena Blvd. \n" +
                "- Radisson Blu \n" +
                "- Sugbutel Bed and Bath \n" +
                "- PCSO Main Office cebu \n" +
                "- Robinsons Mall (reclamation area) \n" +
                "- cebu technological university \n" +
                "- Legaspit Ext. \n" +
                "- Plaza Independencia \n" +
                "- Port San Pedro \n" +
                "- Legaspit St. \n" +
                "- Metropolitan cebu Cathedral \n" +
                "- Sto nino \n" +
                "- V. Gullas St. \n" +
                "- Manalili st. \n" +
                "- Manila Foodshoppe \n" +
                "- Pacific Tourist Inn \n" +
                "- A. Borromeo St \n" +
                "- Sancianko st. \n" +
                "- Airol Pensione House \n" +
                "- Panganiban St. \n" +
                "- CCMC \n" +
                "- N. Bacalso Ave. \n" +
                "- Comglasco \n" +
                "- Katipunan St. \n" +
                "- Tres de Abril St \n" +
                "- Punta Princesa.\n" +
                "\t\n" +
                "\t\n" +
                "* Labangon to SM City Cebu\n" +
                "- Punta Princesa \n" +
                "- F. Llamas St. \n" +
                "- Brgy Tisa \n" +
                "- Gaisano Tisa \n" +
                "- Katipunan St. \n" +
                "- Brgy. Labangon \n" +
                "- Tres de Abril st. \n" +
                "- N. Bacalso Ave. \n" +
                "- Citilink Terminal \n" +
                "- CCMC \n" +
                "- Cebu South Bus Terminal \n" +
                "- E Mall \n" +
                "- ACT \n" +
                "- P. del rosario sT. \n" +
                "- university of san carlos \n" +
                "- Junquera St. \n" +
                "- Colon St. \n" +
                "- Gaisano Main \n" +
                "- University of the Visayas \n" +
                "- Colon Obelisk \n" +
                "- P.Burgos St. \n" +
                "- USPF \n" +
                "- Cebu Metropolitan Cathedral \n" +
                "- F. Urdaneta St. \n" +
                "- MJ. Cuenco ave. \n" +
                "- Legaspi Ext. \n" +
                "- Plaza Indepnedencia \n" +
                "- Fort San Pedro \n" +
                "- Sergio Osmena Ave \n" +
                "- Pier 3 \n" +
                "- Pier 4 \n" +
                "- pier 5 Robinsons Mall \n" +
                "- PCSO \n" +
                "- Sugbutel \n" +
                "- SM City Cebu Terminal", "SM to Labangon (Tres de Abril St.) | Labangon to SM City Cebu"));

        dbHelper.jeepCodeData(new Jeepcode("12L", "* Labangon to Ayala\n" +
                "- Punta Princesa Church \n" +
                "- Tres de Abril \n" +
                "- Salvador St. \n" +
                "- Katipunan St. \n" +
                "- Tres de Abril St. \n" +
                "- N. Bacalso Ave. \n" +
                "- V. Rama Ave. B. Rodriguez Ave. \n" +
                "- Fuente Osmena Circle \n" +
                "- Robinsons Place Cebu (fuente) \n" +
                "- Mango Ave. \n" +
                "- Gen. Maxilom Ave. \n" +
                "- Gorordo Ave. Cebu City Police Station \n" +
                "- Ayala Road \n" +
                "- Ayala Center Cebu PUJ Terminal.\n" +
                "\t\n" +
                "\t\n" +
                "* Ayala to Labangon\n" +
                "- Ayala terminal \n" +
                "- Harold Hotel \n" +
                "- Escario St. \n" +
                "- Cebu Provincial Capitol \n" +
                "- M. Velez St. \n" +
                "- Banawa \n" +
                "- R. Duterte St. \n" +
                "- Rustan's Supermarket (Banawa) \n" +
                "- Salvador Extension \n" +
                "- Katipunana St. \n" +
                "- F. Llamas St. \n" +
                "- Gaisano Capital (Tisa) \n" +
                "- Brgy Tisa \n" +
                "- Punta Princesa \n" +
                "- Punta Princesa Church", "Labangon to Ayala | Ayala to Labangon"));

        dbHelper.jeepCodeData(new Jeepcode("13C", "* Talamban \n" +
                "- Gov. M. Cuenco Ave. \n" +
                "- Gaisano Grand Mall (talamban) \n" +
                "- University of San Carlos (talamban) \n" +
                "- Banilad \n" +
                "- Banilad Town Center \n" +
                "- Gaisano Country Mall \n" +
                "- University of Cebu (Banilad) \n" +
                "- Paradise Village \n" +
                "- Cebu Country Club \n" +
                "- Samantabhadra Institute \n" +
                "- Arch. Reyes Ave. \n" +
                "- BIR - Cebu Business Park \n" +
                "- Pag-ibig Fund \n" +
                "- Ayala Center Cebu \n" +
                "- Mindanao Ave. \n" +
                "- Samar Loop \n" +
                "- Luzon Ave. \n" +
                "- Tune Hotels \n" +
                "- Arch. Reyes Ave. \n" +
                "- Hotel Elizabeth \n" +
                "- Gorordo Ave. \n" +
                "- Asilo dela Melagrosa \n" +
                "- Camp Sutero (Cebu City Police office) \n" +
                "- Gen. Echavez St. \n" +
                "- Sikatuna St. \n" +
                "- Parian \n" +
                "- Colon St. \n" +
                "- Gaisano Main \n" +
                "- University of the Visayas \n" +
                "- Colonnade Supermarket.\n" +
                "\t\n" +
                "\t\n" +
                "* Colon \n" +
                "- Pelaez St. \n" +
                "- University of San Carlos (Main) \n" +
                "- P. del Rosario St. \n" +
                "- Imus Ave. \n" +
                "- M.J. Cuenco Ave. \n" +
                "- Hipodromo \n" +
                "- Mactan St. \n" +
                "- Cebu Business Park \n" +
                "- Leyte Loop \n" +
                "- Samar Loop \n" +
                "- Lexmark \n" +
                "- Mindanao Ave. \n" +
                "- Ayala Center Cebu \n" +
                "- Arch. Reyes Ave. \n" +
                "- BIR - Samantabhadra Institute \n" +
                "- Gov. M. Cuenco Ave. \n" +
                "- Banilad \n" +
                "- UC (banilad) \n" +
                "- Gaisano Country Mall \n" +
                "- Banilad town center \n" +
                "- foodland \n" +
                "- University of San Carlos (Talamban) \n" +
                "- Gaisano Grand Mall(talamban) \n" +
                "- Talamban", "Talamban to Colon | Colon to Talamban"));

        dbHelper.jeepCodeData(new Jeepcode("13B", "* Talamban to Carbon\n" +
                "- Tintay - H. Abella St. \n" +
                "- Gov. M. Cuenco Ave.  Talamban \n" +
                "- Gaisano Grand Talamban \n" +
                "- The Family Park \n" +
                "- University of San Carlos(talamban) \n" +
                "- Gaisano Country Mall \n" +
                "- UC (banilad) \n" +
                "- Arch. Reyes Ave. \n" +
                "- Cebu Business Park \n" +
                "- Mindanao Ave. \n" +
                "- Ayala Center Cebu \n" +
                "- Samar Loop \n" +
                "- Luzon Ave. \n" +
                "- Metro Ayala \n" +
                "- Arch. Reyes Ave. \n" +
                "- Gorordo Ave \n" +
                "- Asilo dela Milagrosa church \n" +
                "- Gen. Echavez St. \n" +
                "- Allson's Inn \n" +
                "- Sikatuna st. \n" +
                "- D. Jakosalem St. \n" +
                "- Echavez Ext. \n" +
                "- Brgy Cogon Ramos \n" +
                "- Ramos Public Market \n" +
                "- Junquera Ext.\n" +
                "- Junquera St. \n" +
                "- University of San Carlos Main \n" +
                "- Colon St.\n" +
                "- Gaisano Main \n" +
                "- University of the Visayas \n" +
                "- Colon Obelisk \n" +
                "- Mabini St. \n" +
                "- V. Gullas St. \n" +
                "- Manalili St. \n" +
                "- Carbon Public Market \n" +
                "- Progreso St. \n" +
                "\t\n" +
                "\t\n" +
                "* Carbon to Talamban\n" +
                "- Carbon Public Market \n" +
                "- MC. Briones St. \n" +
                "- D. Jakosalem St. \n" +
                "- Cebu City Hall \n" +
                "- Magellans Cross \n" +
                "- Basilica del Sto. Nino \n" +
                "- The Freeman \n" +
                "- Gaisano Main \n" +
                "- University of the Visayas \n" +
                "- Ramos Public Market \n" +
                "- Zapatera Brgy. Hall \n" +
                "- Sikatuna St. \n" +
                "- Gen. Echavez St. \n" +
                "- Gorordo ave. \n" +
                "- Arch. Reyes Ave. \n" +
                "- Cebu Business Park \n" +
                "- Luzon Ave. \n" +
                "- Ayala Center Cebu \n" +
                "- Metro Ayala \n" +
                "- Car. Rosales Ave. \n" +
                "- Marriot Hotel \n" +
                "- Mindanao ave. \n" +
                "- Pag \n" +
                "- ibib Fund \n" +
                "- Arch. Reyes Ave. \n" +
                "- Banilad \n" +
                "- Gov. M. Cuenco Ave. \n" +
                "- UC banilad \n" +
                "- Gaisano Country Mall \n" +
                "- University of San Carlos (talamban) \n" +
                "- Talamban \n" +
                "- The Family Park \n" +
                "- Gaisano Grand Talamban \n" +
                "- Tintay", "Talamban to Carbon | Carbon to Talamban via Ramos"));

        dbHelper.jeepCodeData(new Jeepcode("13H", "* Pit-os to Mandaue Public Market\n" +
                "- Pit-os \n" +
                "- Bacayan \n" +
                "- Talamban Rd. \n" +
                "- Cebu North General Hospital \n" +
                "- Talamban - Gov. M. Cuenco Ave. \n" +
                "- Gaisano Grand (talamban) \n" +
                "- The Family Park \n" +
                "- University of San Carlos (talamban) \n" +
                "- Banilad \n" +
                "- University of the Visayas (banilad) \n" +
                "- Foodland - AS. Fortuna St. \n" +
                "- Cebu Home & Builders \n" +
                "- Oftana Suites \n" +
                "- Allure Hotel & Suites \n" +
                "- Benedicto College \n" +
                "- J Centre Mall \n" +
                "- The Orchard Cebu Hotel & Suites \n" +
                "- Highway - AS. Fortuna St. Ext. \n" +
                "- Andy Hotel \n" +
                "- Guizo \n" +
                "- A. del Rosario St. \n" +
                "- Mantuyong \n" +
                "- Sosyoland Supermarket \n" +
                "- Colonnade Supermarket \n" +
                "- North Reclamation Area \n" +
                "- A. Soriano Ave. \n" +
                "- Manduae City Sports Complex \n" +
                "- Bureau of Internal Revenue \n" +
                "- Mandaue City Public Market.\n" +
                "\t\n" +
                "\t\n" +
                "* Mandaue Public Market to Pit-os\n" +
                "- (Merkado) New Manadaue City Public Market \n" +
                "- Bureau of Immigration \n" +
                "- PJ Burgos St. \n" +
                "- Mandaue City Hall \n" +
                "- St. Joseph Parish \n" +
                "- St. Joseph Academy \n" +
                "- Gaisano Grand Mall Mandaue \n" +
                "- A. del Rosario St. \n" +
                "- Mantuyong \n" +
                "- Guizo \n" +
                "- Collegio dela Immaculad Concepcion \n" +
                "- Highway \n" +
                "- San Miguel Brewery Plant \n" +
                "- Coca-cola Bottlers corporation \n" +
                "- AS. Fortuna St. \n" +
                "- J Centre Mall \n" +
                "- PLDT \n" +
                "- Benedicto College \n" +
                "- Larsian (Banilad) \n" +
                "- Oftana Suites \n" +
                "- Oakridge Business Park \n" +
                "- Cebu Home & Builders \n" +
                "- Banilad \n" +
                "- Fords Inn \n" +
                "- Foodland \n" +
                "- University of the Visayas (banilad) \n" +
                "- Bright Academy \n" +
                "- University of San Carlos talamban \n" +
                "- Talamban \n" +
                "- The Family Park \n" +
                "- Gaisano Grand Mall (talamban) \n" +
                "- Talamban Elem. School \n" +
                "- Talamban Brgy. Hall \n" +
                "- Highway 11 \n" +
                "- Talamban Rd. \n" +
                "- Bacayan \n" +
                "- Pit-os", "Pit-os to Mandaue Public Market | Mandaue Public Market to Pit-os"));

        dbHelper.jeepCodeData(new Jeepcode("14D", "* Ayala Terminal to Colon\n" +
                "- Ayala terminal \n" +
                "- harolds hotel \n" +
                "- escario st. \n" +
                "- provincial capitol \n" +
                "- jones avenue \n" +
                "- fuente osmena circle \n" +
                "- robinsons cybergate \n" +
                "- chung hua hospital \n" +
                "- robinsons place cebu (fuente) \n" +
                "- f. ramos st. \n" +
                "- saint paul college foundation (ramos) \n" +
                "- university of san carlos \n" +
                "- junquera st. \n" +
                "- colon st.\n" +
                "- gaisano main \n" +
                "- university of the visayas \n" +
                "- v. gullas st. \n" +
                "- manalili st. \n" +
                "- metro gaisano \n" +
                "- osmena boulevard \n" +
                "- landbank \n" +
                "- central bank of the philippines \n" +
                "- abellana sports complex \n" +
                "- crown regency hotel \n" +
                "- back to fuente osmena circle \n" +
                "- jones avenue \n" +
                "- escario st. \n" +
                "- philhealth \n" +
                "- back to ayala terminal.\n" +
                "\t\n" +
                "\t\n" +
                "* Colon to Ayala Terminal via Fuente Osmena\n" +
                "- Metro gaisano \n" +
                "- osmena boulevard \n" +
                "- landbank \n" +
                "- central bank of the philippines \n" +
                "- abellana sports complex \n" +
                "- crown regency hotel \n" +
                "- back to fuente osmena circle \n" +
                "- jones avenue - cebu doctors hospital \n" +
                "- provincial capitol \n" +
                "- escario st. \n" +
                "- philhealth \n" +
                "- golden peak hotel \n" +
                "- back to ayala terminal", "Pit-os to Mandaue Public Market\n" +
                "via AS. Fortuna St. (Vice-versa)"));

        dbHelper.jeepCodeData(new Jeepcode("14D", "* Ayala Terminal to Colon\n" +
                "- Ayala terminal \n" +
                "- harolds hotel \n" +
                "- escario st. \n" +
                "- provincial capitol \n" +
                "- jones avenue \n" +
                "- fuente osmena circle \n" +
                "- robinsons cybergate \n" +
                "- chung hua hospital \n" +
                "- robinsons place cebu (fuente) \n" +
                "- f. ramos st. \n" +
                "- saint paul college foundation (ramos) \n" +
                "- university of san carlos \n" +
                "- junquera st. \n" +
                "- colon st.\n" +
                "- gaisano main \n" +
                "- university of the visayas \n" +
                "- v. gullas st. \n" +
                "- manalili st. \n" +
                "- metro gaisano \n" +
                "- osmena boulevard \n" +
                "- landbank \n" +
                "- central bank of the philippines \n" +
                "- abellana sports complex \n" +
                "- crown regency hotel \n" +
                "- back to fuente osmena circle \n" +
                "- jones avenue \n" +
                "- escario st. \n" +
                "- philhealth \n" +
                "- back to ayala terminal.\n" +
                "\n" +
                "\t\n" +
                "* Colon to Ayala Terminal via Fuente Osmena\n" +
                "- Metro gaisano \n" +
                "- osmena boulevard \n" +
                "- landbank \n" +
                "- central bank of the philippines \n" +
                "- abellana sports complex \n" +
                "- crown regency hotel \n" +
                "- back to fuente osmena circle \n" +
                "- jones avenue \n" +
                "- cebu doctors hospital \n" +
                "- provincial capitol \n" +
                "- escario st. \n" +
                "- philhealth \n" +
                "- golden peak hotel \n" +
                "- back to ayala terminal", "Ayala Terminal to Colon | " +
                "Colon to Ayala Terminal via Fuente Osmena"));

        dbHelper.jeepCodeData(new Jeepcode("17B", "- Apas \n" +
                "- IT Park \n" +
                "- Geonzon St \n" +
                "- Salinas Drive \n" +
                "- Jy square Mall \n" +
                "- Gorordo Ave. \n" +
                "- UP \n" +
                "- Harolds Hotel \n" +
                "- Escario St. \n" +
                "- Provincial Capitol \n" +
                "- Osmena Blvd \n" +
                "- CDU \n" +
                "- Fuente Osmena Circle \n" +
                "- Robinsons Fuente \n" +
                "- Crown Regency Hotel \n" +
                "- Abellane Sports Complex \n" +
                "- Jones Ave. \n" +
                "- SSS \n" +
                "- Metro Colon \n" +
                "- P. Lopez St. \n" +
                "- Magallanes St. \n" +
                "- Manalili St. \n" +
                "- Carbon Public Market \n" +
                "- Progresso St.\n" +
                "\t\n" +
                "- MC. Briones St. \n" +
                "- Cebu City Hall \n" +
                "- Basilica del Sto. Nino \n" +
                "- La Nueva (cityhall) \n" +
                "- Mj. Cuenco Ave. \n" +
                "- Osmena Blvd \n" +
                "- Lapulapu St. \n" +
                "- Legaspi St. \n" +
                "- Colonnade Supermarket \n" +
                "- Pelaez St. \n" +
                "- University of San Carlos \n" +
                "- Osmena Blvd. \n" +
                "- Cebu Normal University \n" +
                "- Crown Regency Hotel \n" +
                "- Robinsons Fuente \n" +
                "- Fuente Osmena Circle \n" +
                "- CDU \n" +
                "- Provincial Capitol \n" +
                "- Escario St. \n" +
                "- Gorordo Ave \n" +
                "- UP \n" +
                "- Jy Square Mall \n" +
                "- Salinas Drive \n" +
                "- Geonzon St. \n" +
                "- IT Park \n" +
                "- Apas", "Apas to Carbon | Carbon to Apas"));

        dbHelper.jeepCodeData(new Jeepcode("17C", "* Apas to Carbon\n" +
                "\n" +
                "- Apas \n" +
                "- IT Park \n" +
                "- Salinas Drive \n" +
                "- University of the Southern Philippines Foundation (Lahug) \n" +
                "- Jy Square Mall \n" +
                "- Gorordo Ave. \n" +
                "- Lahug High School \n" +
                "- University of the Philippines \n" +
                "- Golden Peak Hotel \n" +
                "- Philhealth \n" +
                "- Royal Concourse \n" +
                "- Asilo dela Milagrosa \n" +
                "- Gen. Maxilom Ave. \n" +
                "- Mango Ave. \n" +
                "- Fooda Saversmart \n" +
                "- Horizons 101 \n" +
                "- Mango Square \n" +
                "- The Beat \n" +
                "- Robinsons Fuente \n" +
                "- F. Ramos St. \n" +
                "- Junquera St. \n" +
                "- University of San Carlos Main \n" +
                "- Sanciangko St. \n" +
                "- University of Cebu Main \n" +
                "- GV Tower \n" +
                "- E Mall \n" +
                "- Panganiban St. \n" +
                "- Magallanes St. \n" +
                "- University of San Jose-Recoletos \n" +
                "- Carbon Public Market \n" +
                "- F. Calderon st. \n" +
                "- Progresso st.\n" +
                "\t\n" +
                "\t\n" +
                "* Carbon to Apas\n" +
                "- Carbon \n" +
                "- MC. Briones St. \n" +
                "- Cebu City Hall \n" +
                "- Basilica del Sto. Nino \n" +
                "- La Nueva Supermarket city hall \n" +
                "- Lapulapu st. \n" +
                "- MCWD \n" +
                "- Legaspi St. \n" +
                "-  Cebu Metropolitan\n" +
                "- Cathedral \n" +
                "- D. Jakosalem St. \n" +
                "- Gaisano Main \n" +
                "- University of the Visayas \n" +
                "- Cogon Ramos \n" +
                "- Ramos Public Market \n" +
                "- F. Ramos St. \n" +
                "- Robinsons Fuente \n" +
                "- Mango Ave. \n" +
                "- Raintree Mall \n" +
                "- Mango Square \n" +
                "- Horizons 101 \n" +
                "- Fooda Saversmart \n" +
                "- Gen Maxilom Ave. \n" +
                "- Gorordo Ave. \n" +
                "- Royal Concourse \n" +
                "- Philhealth \n" +
                "- Golden Peak Hotel \n" +
                "- Tonros Apartelle \n" +
                "- Harolds Hotel \n" +
                "- University of the Philippines \n" +
                "- lahug \n" +
                "- Jy Square Mall \n" +
                "- Salinas Drive \n" +
                "- W. Geonson St. \n" +
                "- Cebu IT Park \n" +
                "- Apas", "Apas to Carbon | Carbon to Apas"));

        dbHelper.jeepCodeData(new Jeepcode("17D", "* Apas to Carbon via Taboan\n" +
                "- Apas \n" +
                "- Wilson St. \n" +
                "- Omega St. \n" +
                "- San Miguel Rd. \n" +
                "- IT Park \n" +
                "- Aegis \n" +
                "- Skyrise 1 \n" +
                "- Skyrise 2 \n" +
                "- Inez Villa St. \n" +
                "- J. Maria del Mar St. \n" +
                "- Skyrise 3 - Abad St. \n" +
                "- W. Geonzon St. \n" +
                "- Salinas Drive \n" +
                "- University of Southern Philippines Foundation \n" +
                "- JY Square Mall \n" +
                "- Lahug \n" +
                "- Gorordo Ave. \n" +
                "- Mormons Church - University of the Philippines \n" +
                "- Harolds Hotel \n" +
                "- Morales St. \n" +
                "- Escario St. \n" +
                "- Cebu Provincial Capitol \n" +
                "- Osmena Blvd. (Jones Ave. \n" +
                "- Cebu Doctors Hospital \n" +
                "- Fuente Osmena Circle \n" +
                "- Robinsons Mall \n" +
                "- Crown Regency Hotel & Suites \n" +
                "- Abellana Sports Complex \n" +
                "- Cebu Normal University \n" +
                "- SSS - Sanciangko St. \n" +
                "- GV Tower \n" +
                "- UC Main \n" +
                "- E Mall \n" +
                "- Taboan Public Market \n" +
                "- Taboan Dried Fish Market \n" +
                "- Lakandula St. \n" +
                "- San Nicolas Parish Church \n" +
                "- Pasil Fish Market \n" +
                "- Spolarium St. \n" +
                "- Magallanes St. \n" +
                "- University of San Jose-Recoletos \n" +
                "- Carbon Public Market \n" +
                "- F. Calderon St. \n" +
                "- Progresso st. \n" +
                "- MC. Briones St.\n" +
                "\t\n" +
                "\t\n" +
                "* Carbon to Apas \n" +
                "- Carbon Public Market \n" +
                "- MC. Briones St. \n" +
                "- Senior Citizens Park \n" +
                "- Cebu City Hall \n" +
                "- Basilica del Sto. Nino \n" +
                "- La Nueva Supermart \n" +
                "- Lapulapu St. \n" +
                "- MCWD \n" +
                "- DTI \n" +
                "- Legaspi St. \n" +
                "- Colonnade Supermarket \n" +
                "- Cebu Century Hotel \n" +
                "- Hotel de Mercedes \n" +
                "- Pelaez St. \n" +
                "- University of San Carlos Main \n" +
                "- P del Rosario St. \n" +
                "- Osmena Blvd. \n" +
                "- Cebu Normal University \n" +
                "- Abellana Sports Center \n" +
                "- Crown Regency Hotel & Suites \n" +
                "- Robinson Place \n" +
                "- Fuente Osmena Circle \n" +
                "- Cebu Doctors Hospital \n" +
                "- Cebu Provincial Capitol \n" +
                "- N. Escario St. \n" +
                "- Cebu Grand Hotel \n" +
                "- Philhealth \n" +
                "- Golden Peak Hotel \n" +
                "- Gorordo Ave. \n" +
                "- Turtles Nest \n" +
                "- Handuraw Pizza \n" +
                "- University of the Philippines \n" +
                "- Lahug \n" +
                "- Mormons Church \n" +
                "- Jy Square Mall \n" +
                "- Salinas Drive \n" +
                "- USP-F - W. Geonzon St. \n" +
                "- Abad St. \n" +
                "- IT Park \n" +
                "- Convergys \n" +
                "- J. Maria del Mar St.\n" +
                "- Skyrise 3 \n" +
                "- Inez Villa St. \n" +
                "- Skyrise 1 \n" +
                "- Skyrise 2 \n" +
                "- Aegis \n" +
                "- Sn Miguel Rd. \n" +
                "- Omega St. \n" +
                "- Wilson St.", "Apas to Carbon via Taboan | Carbon to Apas "));

        dbHelper.jeepCodeData(new Jeepcode("62B", "- Pit-os \n" +
                "- Bacayan \n" +
                "- Talamban \n" +
                "- Gov. M. Cuenco Gaisano Talamban \n" +
                "- The Family Park \n" +
                "- University of San Carlos (talamban campus) \n" +
                "- Gaisano Country Mall - UC-Banilad - Banilad \n" +
                "- Pope John Paul 2 Ave. \n" +
                "- Cebu Business Park \n" +
                "- Ayala Center Cebu \n" +
                "- Marriot Hotel \n" +
                "- Samar Loop \n" +
                "- Luzon Ave. \n" +
                "- Arch. Reyes Ave. \n" +
                "- Gorordo Ave. \n" +
                "- Asilo dela Milagrosa \n" +
                "- Gen. Echavez St. \n" +
                "- Sikatuna St. \n" +
                "- Zapatera \n" +
                "- colon Obelisk \n" +
                "- V. Gullas St. \n" +
                "- Manalili St. \n" +
                "- Carbon Public Market \n" +
                "- Progreso St.\n" +
                "\t\n" +
                "- Carbon Public Market \n" +
                "- MC. Briones St. \n" +
                "- D. Jakosalem St. \n" +
                "- Cebu City Hall \n" +
                "- Basilica del Sto. Nino \n" +
                "- The Freeman \n" +
                "- Gaisano main \n" +
                "- University of the Visayas \n" +
                "- Imus Ave. \n" +
                "- Gen. Maxilom Ave.( Mango Ave.) \n" +
                "- Sorsogon Rd. \n" +
                "- Negros Rd. \n" +
                "- Cardinal Rosales Ave. \n" +
                "- Luzon Ave. \n" +
                "- Metro Ayala \n" +
                "- Ayala PUJ Terminal \n" +
                "- Arch. Reyes Ave. \n" +
                "- Quest Hotel \n" +
                "- Honkong Plaza Hotel \n" +
                "- Gov. M. Cuenco Ave. \n" +
                "- Banilad \n" +
                "- Gaisano Country Mall \n" +
                "- BTC - Foodland \n" +
                "- Univesity of San Carlos (Talamban) \n" +
                "- The Family Park \n" +
                "- Talamban \n" +
                "- Gaisano Grand Talamban \n" +
                "- Talamban Rd. \n" +
                "- Bacayan \n" +
                "- Pit-os", "Pit-os to Carbon | Carbon to Pit-os"));

        dbHelper.jeepCodeData(new Jeepcode("62C", "* PIT-OS TO  CARBON\n" +
                "- Pit-os \n" +
                "- Talamban \n" +
                "- Gaisano Grand Talamban \n" +
                "- USC-talamban \n" +
                "- Banilad \n" +
                "- Gaisano Country mall \n" +
                "- Gov. M.Cuenco ave. \n" +
                "- Juan Luna Ave. \n" +
                "- Sn. Carlos Seminary College \n" +
                "- C. Rosales Ave. \n" +
                "- Ayala Center Cebu \n" +
                "- Keppel \n" +
                "- Samar Loop \n" +
                "- Luzon Ave. \n" +
                "- Arch. Reyes ave. \n" +
                "- Hotel Elizabeth \n" +
                "- Asilo dela Milagrosa \n" +
                "- Gorordo ave. \n" +
                "- G. Echavez St. \n" +
                "- Sikatuna St. \n" +
                "- D. Jakosalem st. \n" +
                "- Ramos Public Market \n" +
                "- Junquera St. ext. \n" +
                "- Junquera st. \n" +
                "- University of San Carlos (main) \n" +
                "- Colon St. \n" +
                "- Gaisano Main \n" +
                "- University of the visayas \n" +
                "- P. Burgos St. \n" +
                "- V. gullas st. \n" +
                "- Manalili st. \n" +
                "- Carbon Public Market \n" +
                "- Progreso st.\n" +
                "\t\n" +
                "\t\n" +
                "* CARBON TO PIT-OS\n" +
                "- Carbon \n" +
                "- MC. Briones St. \n" +
                "- Cebu City Hall \n" +
                "- D. Jakosalem St. \n" +
                "- Basilica del Sto. Nino \n" +
                "- Gaisano Main \n" +
                "- University of the Visayas \n" +
                "- Ramos Pub. Market \n" +
                "- Bayantel \n" +
                "- Sikatuna St. \n" +
                "- Gen. Echavez St. \n" +
                "- Gorordo Ave. \n" +
                "- Arch. Reyes Ave. \n" +
                "- Ayala Puj Terminal \n" +
                "- BIR \n" +
                "- Gov. M. Cuenco Ave. \n" +
                "- Paradise Village \n" +
                "- G. Country Mall \n" +
                "- University of Cebu \n" +
                "-(banilad) \n" +
                "- BAnilad \n" +
                "- Banilad town center \n" +
                "- Foodland \n" +
                "- USC(talamban) \n" +
                "- Talamban \n" +
                "- Bacayan \n" +
                "- Pit-os",
                "Pit-os to Carbon | Carbon to Pit-os"));
        dbHelper.jeepCodeData(new Jeepcode("MI-01A", "* Punta Engano to Opon Public Market\n" +
                "- Punta Engano \n" +
                "- Mactan Shrine \n" +
                "- Mepza \n" +
                "- Marina Mall \n" +
                "- Pusok \n" +
                "- SSS \n" +
                "- Lapulapu City Hall \n" +
                "- Gaisano Island Mall \n" +
                "- Metro-lapulapu \n" +
                "- Opon Public Market.\n" +
                "\n" +
                "\t\n" +
                "* Opon Public Market to Punta Engano\n" +
                "- Gaisano Island Mall \n" +
                "- Lapulapu City Hall \n" +
                "- SSS \n" +
                "- Pusok \n" +
                "- Marina Mall \n" +
                "- Mepza \n" +
                "- Ibo \n" +
                "- Mactan Shrine \n" +
                "- Shangrila Hotel \n" +
                "- Punta Engano",
                "Punta Engano to Opon Public Market " +
                        "| Opon Public Market to Punta Engano"));

        dbHelper.jeepCodeData(new Jeepcode("MI-02B", "* Mandaue to Maribago\n" +
                "- (Mandaue) Parkmall \n" +
                "- W.O. Seno St. \n" +
                "- E.O Perez St. \n" +
                "- S&R Membership Shopping \n" +
                "- P. Larrazabal Ave. \n" +
                "- Cebu Doctors University \n" +
                "- Ouano Ave. \n" +
                "- St. James Amusement Park \n" +
                "- CICC \n" +
                "- A. Soriano Ave. \n" +
                "- New Manadue  Public Market \n" +
                "- Mandaue City Hospital \n" +
                "- Jose L. Briones St. \n" +
                "- University of the Visayas (mandaue) \n" +
                "- Plaridel St. \n" +
                "- Bridges Town Square \n" +
                "- Highland \n" +
                "- Total \n" +
                "- UN Ave. \n" +
                "- Brgy Umapad \n" +
                "- New Mactan-Mandaue Bridge \n" +
                "- Pusok \n" +
                "- ML. Quezon Ntnl Highway \n" +
                "- Marina Mall \n" +
                "- Mepz 1 \n" +
                "- Gate 1, 2, 3, 4, 5 \n" +
                "- Ibo \n" +
                "- Mactan \n" +
                "- Punta Engano Rd. \n" +
                "- Mactan Ocean Town \n" +
                "- Maribago \n" +
                "- Maribago Blue Waters \n" +
                "- Cebu White Sands \n" +
                "- Save More Maribago \n" +
                "- Metro express Maribago. \n" +
                "\t\n" +
                "* Maribago to Mandaue\n" +
                "- Maribago \n" +
                "- Cebu White Sands \n" +
                "- Maribago BlueWater resort \n" +
                "- Brgy. Mactan \n" +
                "- Mactan Oceantown \n" +
                "- Quezon National Highway \n" +
                "- Ibo \n" +
                "- Mepz 1 \n" +
                "- Gate 1, 2, 3, 4, 5 \n" +
                "- Marina Mall Savemore Mactan \n" +
                "- Pusok \n" +
                "- Marcelo B. Fernan Bridge \n" +
                "- UN ave. \n" +
                "- Highland \n" +
                "- Plaridel St. \n" +
                "- Bridges Town Square \n" +
                "- AC Cortes Ave. \n" +
                "- Prince Warehouse (mandue) \n" +
                "- Mandaue Coliseum \n" +
                "- STI College (mandaue) \n" +
                "- BB Cabahug St. \n" +
                "- Mandaue Catholic Cemtery \n" +
                "- Brgy. Guizo \n" +
                "- A. del Rosario St. \n" +
                "- SSS(mandaue) \n" +
                "- Highway \n" +
                "- Tipolo (San Miguel) \n" +
                "- CD. Seno St. \n" +
                "- Hall of Justice \n" +
                "- WO. Seno St. \n" +
                "- Parkmall",
                "Mandaue to Maribago | Maribago to Mandaue"));

        dbHelper.jeepCodeData(new Jeepcode("MI-03A", "* Cordova to Opon Public Market \n" +
                "- Cordova \n" +
                "- Babag 2 \n" +
                "- Deca Homes \n" +
                "- Babag 1 \n" +
                "- Tiangue Rd. \n" +
                "- Looc \n" +
                "- Lapulapu City Central School \n" +
                "- GY. dela Serna St. \n" +
                "- Yanadia \n" +
                "- S. Osmena St. \n" +
                "- Lapulapu City Public Market\n" +
                "\t\n" +
                "\n" +
                "* Opon Public Market to Cordova\n" +
                "- Lapulapu City Public Market (opon) \n" +
                "- L. Jaena St. \n" +
                "- P. Rodriguez St. \n" +
                "- Lapu lapu city Central School \n" +
                "- Tiangue Rd. \n" +
                "- Looc \n" +
                "- Babag 1 \n" +
                "- Deca Homes \n" +
                "- Babag 2 \n" +
                "- Cordova",
                "Cordova to Opon Public Market | Opon Public Market to Cordova"));

        dbHelper.jeepCodeData(new Jeepcode("MI-03B", "* Cordova to Mepz 1 via Opon Public Market\n" +
                "- Cordova \n" +
                "- Quezon National Highway \n" +
                "- Cordova Terminal \n" +
                "- Babab 2 \n" +
                "- Pilipog \n" +
                "- Mactan Circumferential Rd. \n" +
                "- Babag 1 \n" +
                "- Deca Homes \n" +
                "- Canjulao - Looc \n" +
                "- Lapu2x City Central School \n" +
                "- GY. dela Serna St. \n" +
                "- Opon Public Market \n" +
                "- Lapulapu City Public Market \n" +
                "- La Nueva Supermart \n" +
                "- GV Hotel \n" +
                "- Metro Gaisano (opon) \n" +
                "- General Milling Corp. \n" +
                "- ML Quezo Ave. \n" +
                "- Gaisano Mactan \n" +
                "- Lapulapu City Hall \n" +
                "- Goldberry Hotel and Suites \n" +
                "- The Villavista Hotel \n" +
                "- Pusok - Lancaster Hotel \n" +
                "- Marina Mall \n" +
                "- Savemore supermarket (mactan) \n" +
                "- mepz 1 \n" +
                "- gate 1 \n" +
                "- Lear \n" +
                "- Taiyo Yuden \n" +
                "- gate 2 \n" +
                "- gate 3 \n" +
                "- gate 4.\n" +
                "\t\n" +
                "\n" +
                "* Mepz 1 to Cordova via Mactan Ferry Terminal\n" +
                "- Mepz 1 \n" +
                "- Gate 4 \n" +
                "- Gate 3 \n" +
                "- Taiyo Yuden \n" +
                "- Lear \n" +
                "- Gate 2 \n" +
                "- Gate 1 \n" +
                "- Marina Mall \n" +
                "- Savemore supermarket (mactan) \n" +
                "- Pusok \n" +
                "- ML Quezon ave. \n" +
                "- The Bellavista Hotel \n" +
                "- Goldberry Hotel & Suites \n" +
                "- Lapulapu City Hall \n" +
                "- Sss (lapulapu) \n" +
                "- Gaisano Mactan Island Mall \n" +
                "- Dulcenia Hotel and Suites \n" +
                "- General Milling Corp. \n" +
                "- Metro Gaisano Mactan \n" +
                "- Mantawe Rd. \n" +
                "- BM. Dimataga St. \n" +
                "- Poblacion \n" +
                "- Opon Plaza \n" +
                "- Mactan Ferry Boat Terminal \n" +
                "- Birhen Sa Regla (opon) \n" +
                "- R. Rodriguez St. \n" +
                "- Lapulapu City central School \n" +
                "- Tiangue Rd. \n" +
                "- Looc \n" +
                "- Babab 1 \n" +
                "- Deca Homes \n" +
                "- Babag 2 \n" +
                "- Cordova",
                "Cordova to Mepz 1 via Opon Public Market " +
                        "| Mepz 1 to Cordova via Mactan Ferry Terminal"));

        dbHelper.jeepCodeData(new Jeepcode("MI-04B", "* Tamiya to Mepz 1\n" +
                "* (Mepz 2 to Mepz 1)\n" +
                "- Tamiya Terminal \n" +
                "- Robinsons Supermarket (Pueblo Verde) \n" +
                "- MV. Patalinghug Jr. Ave. \n" +
                "- Crown Regency Suites \n" +
                "- Quezon National Highway \n" +
                "- Gaisano Mactan Island Mall \n" +
                "- Lapu-lapu City Hall \n" +
                "- Dulcinea Hotel Suites \n" +
                "- SSS \n" +
                "- The Bellavista Hotel \n" +
                "- Goldberry Suites and Hotel \n" +
                "- Pusok \n" +
                "- Marina Mall \n" +
                "- Savemore Mactan \n" +
                "- Mepz 1 \n" +
                "- Gate 1 \n" +
                "- Gate 2 \n" +
                "- Gate 3 \n" +
                "- Gate 4.\n" +
                "\t\n" +
                "\n" +
                "* Mepz 1 to Mepz 2 (Tamiya Terminal)  \n" +
                "- Mepz 1 \n" +
                "- Gate 4, 3, 2, 1 \n" +
                "- Marina Mall \n" +
                "- Savemore Mactan \n" +
                "- Quezon National Highway \n" +
                "- Pusok \n" +
                "- The Bellavista Hotel \n" +
                "- Goldberry Suites & Hotel \n" +
                "- SSS \n" +
                "- Lapu-lapu City Hall \n" +
                "- Gaisano Mactan Island Mall \n" +
                "- MV. Patalinghug Jr. Ave. \n" +
                "- Crown Regency Suites \n" +
                "- Pueblo Verde \n" +
                "- Robinsons Mactan \n" +
                "- Tamiya Terminal \n" +
                "- Mepz 2", "Tamiya to Mepz 1\n" +
                "(Mepz 2 to Mepz 1) | Mepz 1 to Mepz 2 (Tamiya Terminal)"));

        dbHelper.jeepCodeData(new Jeepcode("MI-04A", "* A. del Rosario St. \n" +
                "- C.D. Seno St. \n" +
                "- Hall of Justice (mandaue) \n" +
                "- Parkmall \n" +
                "- W.O. Seno St. \n" +
                "- E.O. Perez St. \n" +
                "- P. Larazzabal Ave. \n" +
                "- CDU - F.F. Cruz St. \n" +
                "- Ouano Ave. \n" +
                "- St. James Amusement Park \n" +
                "- A. Soriano Ave. \n" +
                "- Mandaue City Hospital \n" +
                "- Jose L. Briones St. \n" +
                "- A.C. Cortez Ave. \n" +
                "- UCLM \n" +
                "- Mactan Mandaue Bridge (OLD) \n" +
                "- M.V. Patalinghug Ave. \n" +
                "- Crown Regency Suites Mactan \n" +
                "- Robinsons Supermarket mactan \n" +
                "- Tamiya Terminal.  \n" +
                "\n" +
                "\t\n" +
                "* Tamiya Terminal(MEPZ 2) \n" +
                "- Robinsons Supermarket(mactan) \n" +
                "- Marigondon to Basak Road \n" +
                "- Crown Regency Suites(mactan) \n" +
                "- Mandaue Mactan Bridge(OLD) \n" +
                "- UC-LM \n" +
                "- A.C. Cortes Ave. \n" +
                "- Prince Warehouse Club (mandaue) \n" +
                "- B.b. Cabahug St. \n" +
                "- A. del Rosario St.",
                "Mandaue (parkmall) to Tamiya Terminal | Tamiya Terminal to Mandaue (parkmall)"));

        dbHelper.jeepCodeData(new Jeepcode("MI-05A", "* Mactan Airport \n" +
                "- Marina Mall \n" +
                "- Quezon National Highway \n" +
                "- Pusok \n" +
                "- Hotel Cesario \n" +
                "- SSS (Lapu2x branch) \n" +
                "- Lapulapu City Hall \n" +
                "- Gaisano Mactan Island Mall \n" +
                "- General Milling Corporation \n" +
                "- Gaisano Metro (opon) \n" +
                "- Mantawe Road \n" +
                "- B.M. Dimataga St. \n" +
                "- Muelle Osmena Port \n" +
                "- Cebu-Mactan Ferry Terminal.\n" +
                " \n" +
                "\t\n" +
                "* Muelle Osmena Port (Cebu-mactan Ferry Terminal) \n" +
                "- Our Lady of Rule Parish \n" +
                "- R. Rodriguez St. \n" +
                "- G.Y. dela Serna St. \n" +
                "- Opon Public Market \n" +
                "- La Nueva Supermart \n" +
                "- M.L. Quezon Ave. \n" +
                "- Gaisano Metro (opon) \n" +
                "- Gaisano Mactan Island Mall \n" +
                "- Lapulapu City Hall \n" +
                "- Pusok \n" +
                "- Marina Mall \n" +
                "- Mactan Cebu International Airport Authority",
                "Mactan airport to Opon (Muelle osmena ferry boat terminal) | Opon to Mactan Airport"));

        dbHelper.jeepCodeData(new Jeepcode("MI-23A", "* Opon to Mandaue\n" +
                "- Opon PUJ terminal \n" +
                "- ML. Quezon Ave. \n" +
                "- OLD Mactan-Mandaue Bridge \n" +
                "- AC. Cortes Ave. \n" +
                "- UCLM \n" +
                "- Natures Spring Plant \n" +
                "- Mandaue Coliseum \n" +
                "- STI \n" +
                "- B. B. Cabahug St. \n" +
                "- Mandaue Catholic Cemetery \n" +
                "- A. del Rosario St. \n" +
                "- Guizo \n" +
                "- C.D. Seno \n" +
                "- Cicc \n" +
                "- Parkmall\n" +
                "\t\n" +
                "\n" +
                "* Mandaue to Opon \n" +
                "- Parkmall \n" +
                "- W.O. Seno St. \n" +
                "- E.O Perez St. \n" +
                "- S&R Shopping \n" +
                "- P. Larazzabal Ave. \n" +
                "- Cebu Doctors University \n" +
                "- Ouano Ave. \n" +
                "- CICC \n" +
                "- New Mandaue Public Market \n" +
                "- J.L. Briones St. \n" +
                "- Norkis Park \n" +
                "- University of the Visayas \n" +
                "- AC. Cortes Ave. \n" +
                "- Natures Spring Plant \n" +
                "- UC-LM \n" +
                "- Old  Mandaue-Mactan Bridge \n" +
                "- ML. Quezon Ave. \n" +
                "- General Milling Corp. \n" +
                "- Metro Mactan \n" +
                "- Mantawe Rd. \n" +
                "- Ompad St. \n" +
                "- GY dela Serna St. \n" +
                "- La Nueva Supermart \n" +
                "- Opon PUJ terminal \n MI-23A also named as 23D",
                "Opon to Mandaue | Mandaue to Opon"));
    }
}
