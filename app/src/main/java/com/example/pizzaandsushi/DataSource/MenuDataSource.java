package com.example.pizzaandsushi.DataSource;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.pizzaandsushi.Model.MenuField;
import com.example.pizzaandsushi.Model.PositionField;
import com.example.pizzaandsushi.R;

import java.util.ArrayList;
import java.util.List;

public class MenuDataSource {
    public static LiveData<List<MenuField>> setInitialDataMenu(Context context) {
        MutableLiveData<List<MenuField>> result = new MutableLiveData<>();
        ArrayList<MenuField> menu = new ArrayList<>();
        menu.add(new MenuField(context.getString(R.string.japan_cuisine), R.mipmap.japan_cuisine_foreground));
        menu.add(new MenuField(context.getString(R.string.italian_cuisine), R.mipmap.italian_cuisine_foreground));
        menu.add(new MenuField(context.getString(R.string.salad), R.mipmap.salat_foreground));
        menu.add(new MenuField(context.getString(R.string.desserts), R.mipmap.desserts_foreground));
        menu.add(new MenuField(context.getString(R.string.drinks), R.mipmap.drinks_foreground));
        result.setValue(menu);
        return result;
    }

    public static LiveData<ArrayList<ArrayList<PositionField>>> setInitialDataPosition(Context context) {
        MutableLiveData<ArrayList<ArrayList<PositionField>>> result = new MutableLiveData<>();
        ArrayList<ArrayList<PositionField>> position = new ArrayList<>();
        position.add(Japan(context));
        position.add(Italian(context));
        position.add(Salad(context));
        position.add(Desserts(context));
        position.add(Drinks(context));
        result.setValue(position);
        return result;
    }

    private static ArrayList<PositionField> Japan(Context context) {
        ArrayList<PositionField> field = new ArrayList<>();
        field.add(new PositionField(context.getString(R.string.california_salmon_light), R.mipmap.california__salmon_light_foreground, context.getString(R.string.Title_california_salmon_light)));
        field.add(new PositionField(context.getString(R.string.california_salmon), R.mipmap.california__salmon_foreground, context.getString(R.string.Title_california_salmon)));
        field.add(new PositionField(context.getString(R.string.california_light), R.mipmap.california__light_foreground, context.getString(R.string.Title_california_light)));
        field.add(new PositionField(context.getString(R.string.california), R.mipmap.california__foreground, context.getString(R.string.Title_california)));
        field.add(new PositionField(context.getString(R.string.california_dream), R.mipmap.california__dream_foreground, context.getString(R.string.Title_california_dream)));
        field.add(new PositionField(context.getString(R.string.california_eel), R.mipmap.california__eel_foreground, context.getString(R.string.Title_california_eel)));
        field.add(new PositionField(context.getString(R.string.mexican), R.mipmap.mexican_foreground, context.getString(R.string.Title_mexican)));
        field.add(new PositionField(context.getString(R.string.prime_light), R.mipmap.prime_light_foreground, context.getString(R.string.Title_prime_light)));
        field.add(new PositionField(context.getString(R.string.prime), R.mipmap.prime_foreground, context.getString(R.string.Title_prime)));
        field.add(new PositionField(context.getString(R.string.philadelphia_light), R.mipmap.philadelphia_light_foreground, context.getString(R.string.Title_philadelphia_light)));
        field.add(new PositionField(context.getString(R.string.philadelphia), R.mipmap.philadelphia_foreground, context.getString(R.string.Title_philadelphia)));
        field.add(new PositionField(context.getString(R.string.dragon_light), R.mipmap.dragon__light_foreground, context.getString(R.string.Title_dragon_light)));
        field.add(new PositionField(context.getString(R.string.dragon), R.mipmap.dragon_foreground, context.getString(R.string.Title_dragon)));
        field.add(new PositionField(context.getString(R.string.Yumiko), R.mipmap.yumiko__foreground, context.getString(R.string.Title_Yumiko)));
        field.add(new PositionField(context.getString(R.string.Ozu), R.mipmap.ozu__foreground, context.getString(R.string.Title_Ozu)));
        field.add(new PositionField(context.getString(R.string.rolls_salmon), R.mipmap.salmon_roll_foreground, context.getString(R.string.Title_rolls_salmon)));
        field.add(new PositionField(context.getString(R.string.rolls_tuna), R.mipmap.tuna_roll_foreground, context.getString(R.string.Title_rolls_tuna)));
        field.add(new PositionField(context.getString(R.string.rolls_eel), R.mipmap.eel_roll_foreground, context.getString(R.string.Title_rolls_eel)));
        field.add(new PositionField(context.getString(R.string.rolls_avocado), R.mipmap.avocado_roll_foreground, context.getString(R.string.Title_rolls_avocado)));
        field.add(new PositionField(context.getString(R.string.rolls_cucumber), R.mipmap.cucumber_roll_foreground, context.getString(R.string.Title_rolls_cucumber)));
        field.add(new PositionField("", R.mipmap.sushi_salmon_foreground, context.getString(R.string.Title_sushi_salmon)));
        field.add(new PositionField("", R.mipmap.sushi_smoked_salmon_foreground, context.getString(R.string.Title_sushi_smoked_salmon)));
        field.add(new PositionField("", R.mipmap.sushi_tuna_foreground, context.getString(R.string.Title_sushi_tuna)));
        field.add(new PositionField("", R.mipmap.sushi_shrimp_foreground, context.getString(R.string.Title_sushi_shrimp)));
        field.add(new PositionField("", R.mipmap.sushi_eel_foreground, context.getString(R.string.Title_sushi_eel)));
        field.add(new PositionField("", R.mipmap.salmon_spice_foreground, context.getString(R.string.Title_salmon_spice)));
        field.add(new PositionField("", R.mipmap.scallop_spice_foreground, context.getString(R.string.Title_scallop_spice)));
        field.add(new PositionField("", R.mipmap.shrimp_spice_foreground, context.getString(R.string.Title_shrimp_spice)));
        field.add(new PositionField("", R.mipmap.tuna_spice_foreground, context.getString(R.string.Title_tuna_spice)));
        field.add(new PositionField("", R.mipmap.eel_spice_foreground, context.getString(R.string.Title_eel_spice)));
        field.add(new PositionField("", R.mipmap.crab_spice_foreground, context.getString(R.string.Title_crab_spice)));
        field.add(new PositionField("", R.mipmap.chuka_foreground, context.getString(R.string.Title_chuka)));
        field.add(new PositionField("", R.mipmap.flying_fish_caviar_foreground, context.getString(R.string.Title_flying_fish_caviar)));
        field.add(new PositionField("", R.mipmap.red_caviar_foreground, context.getString(R.string.Title_red_caviar)));
        return field;
    }

    private static ArrayList<PositionField> Italian(Context context) {
        ArrayList<PositionField> field = new ArrayList<>();
        field.add(new PositionField("", R.mipmap.italian_cuisine_foreground, "Coming soon"));
        return field;
    }

    private static ArrayList<PositionField> Salad(Context context) {
        ArrayList<PositionField> field = new ArrayList<>();
        field.add(new PositionField(context.getString(R.string.caesar_with_chicken), R.mipmap.caesar_with_chicken_foreground, context.getString(R.string.Title_caesar_with_chicken)));
        field.add(new PositionField(context.getString(R.string.caesar_with_shrimp), R.mipmap.caesar_with_shrimp_foreground, context.getString(R.string.Title_caesar_with_shrimp)));
        field.add(new PositionField(context.getString(R.string.chuka_with_nut_sauce), R.mipmap.chuka_with_nut_sauce_foreground, context.getString(R.string.Title_chuka_with_nut_sauce)));
        field.add(new PositionField(context.getString(R.string.kumotori), R.mipmap.kumotori_foreground, context.getString(R.string.Title_kumotory)));
        field.add(new PositionField(context.getString(R.string.sendai), R.mipmap.sendai_foreground, context.getString(R.string.Title_sendai)));
        field.add(new PositionField(context.getString(R.string.keiko), R.mipmap.keiko_foreground, context.getString(R.string.Title_keiko)));
        field.add(new PositionField(context.getString(R.string.toruko), R.mipmap.toruko_foreground, context.getString(R.string.Title_toruko)));
        field.add(new PositionField(context.getString(R.string.akarui), R.mipmap.akarui_foreground, context.getString(R.string.Title_akarui)));
        field.add(new PositionField(context.getString(R.string.nicoise), R.mipmap.nicoise_foreground, context.getString(R.string.Title_nicoise)));
        field.add(new PositionField(context.getString(R.string.shinshiro), R.mipmap.shinshiro_foreground, context.getString(R.string.Title_shinshiro)));
        field.add(new PositionField(context.getString(R.string.greek_salad), R.mipmap.greek_salad_foreground, context.getString(R.string.Title_greek_salad)));
        field.add(new PositionField(context.getString(R.string.salmon_salad), R.mipmap.salmon_salad_foreground, context.getString(R.string.Title_salmon_salad)));
        field.add(new PositionField(context.getString(R.string.green_salad_with_edamame_and_mozzarella), R.mipmap.green_salad_with_edamame_and_mozzarella_foreground, context.getString(R.string.Title_green_salad_with_edamame_and_mozzarella)));
        return field;
    }

    private static ArrayList<PositionField> Desserts(Context context) {
        ArrayList<PositionField> field = new ArrayList<>();
        field.add(new PositionField(context.getString(R.string.kuro_eru), R.mipmap.kuro_eru_foreground, context.getString(R.string.Title_kuro_eru)));
        field.add(new PositionField(context.getString(R.string.manila_roll), R.mipmap.manila_roll_foreground, context.getString(R.string.Title_manila_roll)));
        field.add(new PositionField(context.getString(R.string.fruit_roll), R.mipmap.fruit_roll_foreground, context.getString(R.string.Title_fruit_roll)));
        field.add(new PositionField(context.getString(R.string.chocolate_roll), R.mipmap.chocolate_roll_foreground, context.getString(R.string.Title_chocolate_roll)));
        field.add(new PositionField(context.getString(R.string.roku_san), R.mipmap.roku_san_foreground, context.getString(R.string.Title_roku_san)));
        field.add(new PositionField(context.getString(R.string.amai_miru), R.mipmap.amai_miru_foreground, context.getString(R.string.Title_amai_miru)));
        field.add(new PositionField(context.getString(R.string.cheesecake), R.mipmap.cheesecake_foreground, context.getString(R.string.Title_cheesecake)));
        field.add(new PositionField(context.getString(R.string.tiramisu), R.mipmap.tiramisu_foreground, context.getString(R.string.Title_tiramisu)));
        field.add(new PositionField(context.getString(R.string.medovik), R.mipmap.medovik_foreground, context.getString(R.string.Title_medovik)));
        field.add(new PositionField(context.getString(R.string.red_velvet), R.mipmap.red_velvet_foreground, context.getString(R.string.Title_red_velvet)));
        return field;
    }

    private static ArrayList<PositionField> Drinks(Context context) {
        ArrayList<PositionField> field = new ArrayList<>();
        field.add(new PositionField("", R.mipmap.drinks_foreground, "Coming soon"));
        return field;
    }
}