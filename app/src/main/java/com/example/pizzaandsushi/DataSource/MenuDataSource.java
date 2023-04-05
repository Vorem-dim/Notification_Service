package com.example.pizzaandsushi.DataSource;

import android.content.res.Resources;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.pizzaandsushi.Model.MenuField;
import com.example.pizzaandsushi.Model.PositionField;
import com.example.pizzaandsushi.R;

import java.util.ArrayList;
import java.util.List;

public class MenuDataSource {
    public static LiveData<List<MenuField>> setInitialDataMenu() {
        MutableLiveData<List<MenuField>> result = new MutableLiveData<>();
        ArrayList<MenuField> menu = new ArrayList<>();
        menu.add(new MenuField(String.valueOf(R.string.japan_cuisine), R.mipmap.japan_cuisine_foreground));
        menu.add(new MenuField(String.valueOf(R.string.italian_cuisine), R.mipmap.italian_cuisine_foreground));
        menu.add(new MenuField(String.valueOf(R.string.salad), R.mipmap.salat_foreground));
        menu.add(new MenuField(String.valueOf(R.string.desserts), R.mipmap.desserts_foreground));
        menu.add(new MenuField(String.valueOf(R.string.drinks), R.mipmap.drinks_foreground));
        result.setValue(menu);
        return result;
    }

    public static LiveData<ArrayList<ArrayList<PositionField>>> setInitialDataPosition() {
        MutableLiveData<ArrayList<ArrayList<PositionField>>> result = new MutableLiveData<>();
        ArrayList<ArrayList<PositionField>> position = new ArrayList<>();
        position.add(Japan());
        position.add(Italian());
        position.add(Salad());
        position.add(Desserts());
        position.add(Drinks());
        result.setValue(position);
        return result;
    }

    private static ArrayList<PositionField> Japan() {
        ArrayList<PositionField> field = new ArrayList<>();
        field.add(new PositionField(String.valueOf(R.string.california_salmon_light), R.mipmap.california__salmon_light_foreground, String.valueOf(R.string.Title_california_salmon_light)));
        field.add(new PositionField(String.valueOf(R.string.california_salmon), R.mipmap.california__salmon_foreground, String.valueOf(R.string.Title_california_salmon)));
        field.add(new PositionField(String.valueOf(R.string.california_light), R.mipmap.california__light_foreground, String.valueOf(R.string.Title_california_light)));
        field.add(new PositionField(String.valueOf(R.string.california), R.mipmap.california__foreground, String.valueOf(R.string.Title_california)));
        field.add(new PositionField(String.valueOf(R.string.california_dream), R.mipmap.california__dream_foreground, String.valueOf(R.string.Title_california_dream)));
        field.add(new PositionField(String.valueOf(R.string.california_eel), R.mipmap.california__eel_foreground, String.valueOf(R.string.Title_california_eel)));
        field.add(new PositionField(String.valueOf(R.string.mexican), R.mipmap.mexican_foreground, String.valueOf(R.string.Title_mexican)));
        field.add(new PositionField(String.valueOf(R.string.prime_light), R.mipmap.prime_light_foreground, String.valueOf(R.string.Title_prime_light)));
        field.add(new PositionField(String.valueOf(R.string.prime), R.mipmap.prime_foreground, String.valueOf(R.string.Title_prime)));
        field.add(new PositionField(String.valueOf(R.string.philadelphia_light), R.mipmap.philadelphia_light_foreground, String.valueOf(R.string.Title_philadelphia_light)));
        field.add(new PositionField(String.valueOf(R.string.philadelphia), R.mipmap.philadelphia_foreground, String.valueOf(R.string.Title_philadelphia)));
        field.add(new PositionField(String.valueOf(R.string.dragon_light), R.mipmap.dragon__light_foreground, String.valueOf(R.string.Title_dragon_light)));
        field.add(new PositionField(String.valueOf(R.string.dragon), R.mipmap.dragon_foreground, String.valueOf(R.string.Title_dragon)));
        field.add(new PositionField(String.valueOf(R.string.Yumiko), R.mipmap.yumiko__foreground, String.valueOf(R.string.Title_Yumiko)));
        field.add(new PositionField(String.valueOf(R.string.Ozu), R.mipmap.ozu__foreground, String.valueOf(R.string.Title_Ozu)));
        field.add(new PositionField(String.valueOf(R.string.rolls_salmon), R.mipmap.salmon_roll_foreground, String.valueOf(R.string.Title_rolls_salmon)));
        field.add(new PositionField(String.valueOf(R.string.rolls_tuna), R.mipmap.tuna_roll_foreground, String.valueOf(R.string.Title_rolls_tuna)));
        field.add(new PositionField(String.valueOf(R.string.rolls_eel), R.mipmap.eel_roll_foreground, String.valueOf(R.string.Title_rolls_eel)));
        field.add(new PositionField(String.valueOf(R.string.rolls_avocado), R.mipmap.avocado_roll_foreground, String.valueOf(R.string.Title_rolls_avocado)));
        field.add(new PositionField(String.valueOf(R.string.rolls_cucumber), R.mipmap.cucumber_roll_foreground, String.valueOf(R.string.Title_rolls_cucumber)));
        field.add(new PositionField("", R.mipmap.sushi_salmon_foreground, String.valueOf(R.string.Title_sushi_salmon)));
        field.add(new PositionField("", R.mipmap.sushi_smoked_salmon_foreground, String.valueOf(R.string.Title_sushi_smoked_salmon)));
        field.add(new PositionField("", R.mipmap.sushi_tuna_foreground, String.valueOf(R.string.Title_sushi_tuna)));
        field.add(new PositionField("", R.mipmap.sushi_shrimp_foreground, String.valueOf(R.string.Title_sushi_shrimp)));
        field.add(new PositionField("", R.mipmap.sushi_eel_foreground, String.valueOf(R.string.Title_sushi_eel)));
        field.add(new PositionField("", R.mipmap.salmon_spice_foreground, String.valueOf(R.string.Title_salmon_spice)));
        field.add(new PositionField("", R.mipmap.scallop_spice_foreground, String.valueOf(R.string.Title_scallop_spice)));
        field.add(new PositionField("", R.mipmap.shrimp_spice_foreground, String.valueOf(R.string.Title_shrimp_spice)));
        field.add(new PositionField("", R.mipmap.tuna_spice_foreground, String.valueOf(R.string.Title_tuna_spice)));
        field.add(new PositionField("", R.mipmap.eel_spice_foreground, String.valueOf(R.string.Title_eel_spice)));
        field.add(new PositionField("", R.mipmap.crab_spice_foreground, String.valueOf(R.string.Title_crab_spice)));
        field.add(new PositionField("", R.mipmap.chuka_foreground, String.valueOf(R.string.Title_chuka)));
        field.add(new PositionField("", R.mipmap.flying_fish_caviar_foreground, String.valueOf(R.string.Title_flying_fish_caviar)));
        field.add(new PositionField("", R.mipmap.red_caviar_foreground, String.valueOf(R.string.Title_red_caviar)));
        return field;
    }

    private static ArrayList<PositionField> Italian() {
        ArrayList<PositionField> field = new ArrayList<>();
        field.add(new PositionField("", R.mipmap.italian_cuisine_foreground, "Coming soon"));
        return field;
    }

    private static ArrayList<PositionField> Salad() {
        ArrayList<PositionField> field = new ArrayList<>();
        field.add(new PositionField(String.valueOf(R.string.caesar_with_chicken), R.mipmap.caesar_with_chicken_foreground, String.valueOf(R.string.Title_caesar_with_chicken)));
        field.add(new PositionField(String.valueOf(R.string.caesar_with_shrimp), R.mipmap.caesar_with_shrimp_foreground, String.valueOf(R.string.Title_caesar_with_shrimp)));
        field.add(new PositionField(String.valueOf(R.string.chuka_with_nut_sauce), R.mipmap.chuka_with_nut_sauce_foreground, String.valueOf(R.string.Title_chuka_with_nut_sauce)));
        field.add(new PositionField(String.valueOf(R.string.kumotori), R.mipmap.kumotori_foreground, String.valueOf(R.string.Title_kumotory)));
        field.add(new PositionField(String.valueOf(R.string.sendai), R.mipmap.sendai_foreground, String.valueOf(R.string.Title_sendai)));
        field.add(new PositionField(String.valueOf(R.string.keiko), R.mipmap.keiko_foreground, String.valueOf(R.string.Title_keiko)));
        field.add(new PositionField(String.valueOf(R.string.toruko), R.mipmap.toruko_foreground, String.valueOf(R.string.Title_toruko)));
        field.add(new PositionField(String.valueOf(R.string.akarui), R.mipmap.akarui_foreground, String.valueOf(R.string.Title_akarui)));
        field.add(new PositionField(String.valueOf(R.string.nicoise), R.mipmap.nicoise_foreground, String.valueOf(R.string.Title_nicoise)));
        field.add(new PositionField(String.valueOf(R.string.shinshiro), R.mipmap.shinshiro_foreground, String.valueOf(R.string.Title_shinshiro)));
        field.add(new PositionField(String.valueOf(R.string.greek_salad), R.mipmap.greek_salad_foreground, String.valueOf(R.string.Title_greek_salad)));
        field.add(new PositionField(String.valueOf(R.string.salmon_salad), R.mipmap.salmon_salad_foreground, String.valueOf(R.string.Title_salmon_salad)));
        field.add(new PositionField(String.valueOf(R.string.green_salad_with_edamame_and_mozzarella), R.mipmap.green_salad_with_edamame_and_mozzarella_foreground, String.valueOf(R.string.Title_green_salad_with_edamame_and_mozzarella)));
        return field;
    }

    private static ArrayList<PositionField> Desserts() {
        ArrayList<PositionField> field = new ArrayList<>();
        field.add(new PositionField(String.valueOf(R.string.kuro_eru), R.mipmap.kuro_eru_foreground, String.valueOf(R.string.Title_kuro_eru)));
        field.add(new PositionField(String.valueOf(R.string.manila_roll), R.mipmap.manila_roll_foreground, String.valueOf(R.string.Title_manila_roll)));
        field.add(new PositionField(String.valueOf(R.string.fruit_roll), R.mipmap.fruit_roll_foreground, String.valueOf(R.string.Title_fruit_roll)));
        field.add(new PositionField(String.valueOf(R.string.chocolate_roll), R.mipmap.chocolate_roll_foreground, String.valueOf(R.string.Title_chocolate_roll)));
        field.add(new PositionField(String.valueOf(R.string.roku_san), R.mipmap.roku_san_foreground, String.valueOf(R.string.Title_roku_san)));
        field.add(new PositionField(String.valueOf(R.string.amai_miru), R.mipmap.amai_miru_foreground, String.valueOf(R.string.Title_amai_miru)));
        field.add(new PositionField(String.valueOf(R.string.cheesecake), R.mipmap.cheesecake_foreground, String.valueOf(R.string.Title_cheesecake)));
        field.add(new PositionField(String.valueOf(R.string.tiramisu), R.mipmap.tiramisu_foreground, String.valueOf(R.string.Title_tiramisu)));
        field.add(new PositionField(String.valueOf(R.string.medovik), R.mipmap.medovik_foreground, String.valueOf(R.string.Title_medovik)));
        field.add(new PositionField(String.valueOf(R.string.red_velvet), R.mipmap.red_velvet_foreground, String.valueOf(R.string.Title_red_velvet)));
        return field;
    }

    private static ArrayList<PositionField> Drinks() {
        ArrayList<PositionField> field = new ArrayList<>();
        field.add(new PositionField("", R.mipmap.drinks_foreground, "Coming soon"));
        return field;
    }
}