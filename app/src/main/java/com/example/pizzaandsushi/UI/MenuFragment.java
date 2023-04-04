package com.example.pizzaandsushi.UI;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzaandsushi.Model.MenuField;
import com.example.pizzaandsushi.Model.PositionField;
import com.example.pizzaandsushi.R;
import com.example.pizzaandsushi.RecyclerMenu;
import com.example.pizzaandsushi.RecyclerPosition;

import java.util.ArrayList;

public class MenuFragment extends Fragment {
    private ArrayList<ArrayList<PositionField>> position = new ArrayList<>();
    private RecyclerPosition.OnClickListener ListenerPosition;
    private RecyclerPosition adapter_position;
    private RecyclerView ListPosition;
    private ArrayList<MenuField> menu = new ArrayList<>();
    private RecyclerMenu.OnClickListener ListenerMenu;
    private RecyclerMenu adapter_menu;
    private RecyclerView ListMenu;

    public MenuFragment() {
        super(R.layout.fragment_menu);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        menu.add(new MenuField(getString(R.string.japan_cuisine), R.mipmap.japan_cuisine_foreground));
        menu.add(new MenuField(getString(R.string.italian_cuisine), R.mipmap.italian_cuisine_foreground));
        menu.add(new MenuField(getString(R.string.salad), R.mipmap.salat_foreground));
        menu.add(new MenuField(getString(R.string.desserts), R.mipmap.desserts_foreground));
        menu.add(new MenuField(getString(R.string.drinks), R.mipmap.drinks_foreground));
        ListMenu = view.findViewById(R.id.RecyclerCuisine);
        ListenerMenu = new RecyclerMenu.OnClickListener() {
            @Override
            public void OnClick(MenuField field, int position) {
                ChangePosition(position);
            }
        };
        adapter_menu = new RecyclerMenu(getContext(), menu, ListenerMenu);
        ListMenu.setAdapter(adapter_menu);


        position.add(Japan());
        position.add(Italian());
        position.add(Salad());
        position.add(Desserts());
        position.add(Drinks());
        ListPosition = view.findViewById(R.id.RecyclerMenu);
        ListenerPosition = new RecyclerPosition.OnClickListener() {
            @Override
            public void OnClick(PositionField field, int position) {

            }
        };
        adapter_position = new RecyclerPosition(getContext(), position.get(0), ListenerPosition);
        ListPosition.setAdapter(adapter_position);

        ImageButton button1 = view.findViewById(R.id.Menu_button);
        button1.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction().replace(R.id.FragmentContainerView, MenuFragment.class, null).commit();
        });

        ImageButton button2 = view.findViewById(R.id.Profile_icon_button);
        button2.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction().replace(R.id.FragmentContainerView, ProfileFragment.class, null).commit();
        });

        ImageButton button3 = view.findViewById(R.id.Basket_button);
        button3.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction().replace(R.id.FragmentContainerView, BasketFragment.class, null).commit();
        });
    }

    private ArrayList<PositionField> Japan() {
        ArrayList<PositionField> field = new ArrayList<>();
        field.add(new PositionField(getString(R.string.california_salmon_light), R.mipmap.california__salmon_light_foreground, getString(R.string.Title_california_salmon_light)));
        field.add(new PositionField(getString(R.string.california_salmon), R.mipmap.california__salmon_foreground, getString(R.string.Title_california_salmon)));
        field.add(new PositionField(getString(R.string.california_light), R.mipmap.california__light_foreground, getString(R.string.Title_california_light)));
        field.add(new PositionField(getString(R.string.california), R.mipmap.california__foreground, getString(R.string.Title_california)));
        field.add(new PositionField(getString(R.string.california_dream), R.mipmap.california__dream_foreground, getString(R.string.Title_california_dream)));
        field.add(new PositionField(getString(R.string.california_eel), R.mipmap.california__eel_foreground, getString(R.string.Title_california_eel)));
        field.add(new PositionField(getString(R.string.mexican), R.mipmap.mexican_foreground, getString(R.string.Title_mexican)));
        field.add(new PositionField(getString(R.string.prime_light), R.mipmap.prime_light_foreground, getString(R.string.Title_prime_light)));
        field.add(new PositionField(getString(R.string.prime), R.mipmap.prime_foreground, getString(R.string.Title_prime)));
        field.add(new PositionField(getString(R.string.philadelphia_light), R.mipmap.philadelphia_light_foreground, getString(R.string.Title_philadelphia_light)));
        field.add(new PositionField(getString(R.string.philadelphia), R.mipmap.philadelphia_foreground, getString(R.string.Title_philadelphia)));
        field.add(new PositionField(getString(R.string.dragon_light), R.mipmap.dragon__light_foreground, getString(R.string.Title_dragon_light)));
        field.add(new PositionField(getString(R.string.dragon), R.mipmap.dragon_foreground, getString(R.string.Title_dragon)));
        field.add(new PositionField(getString(R.string.Yumiko), R.mipmap.yumiko__foreground, getString(R.string.Title_Yumiko)));
        field.add(new PositionField(getString(R.string.Ozu), R.mipmap.ozu__foreground, getString(R.string.Title_Ozu)));
        field.add(new PositionField(getString(R.string.rolls_salmon), R.mipmap.salmon_roll_foreground, getString(R.string.Title_rolls_salmon)));
        field.add(new PositionField(getString(R.string.rolls_tuna), R.mipmap.tuna_roll_foreground, getString(R.string.Title_rolls_tuna)));
        field.add(new PositionField(getString(R.string.rolls_eel), R.mipmap.eel_roll_foreground, getString(R.string.Title_rolls_eel)));
        field.add(new PositionField(getString(R.string.rolls_avocado), R.mipmap.avocado_roll_foreground, getString(R.string.Title_rolls_avocado)));
        field.add(new PositionField(getString(R.string.rolls_cucumber), R.mipmap.cucumber_roll_foreground, getString(R.string.Title_rolls_cucumber)));
        field.add(new PositionField("", R.mipmap.sushi_salmon_foreground, getString(R.string.Title_sushi_salmon)));
        field.add(new PositionField("", R.mipmap.sushi_smoked_salmon_foreground, getString(R.string.Title_sushi_smoked_salmon)));
        field.add(new PositionField("", R.mipmap.sushi_tuna_foreground, getString(R.string.Title_sushi_tuna)));
        field.add(new PositionField("", R.mipmap.sushi_shrimp_foreground, getString(R.string.Title_sushi_shrimp)));
        field.add(new PositionField("", R.mipmap.sushi_eel_foreground, getString(R.string.Title_sushi_eel)));
        field.add(new PositionField("", R.mipmap.salmon_spice_foreground, getString(R.string.Title_salmon_spice)));
        field.add(new PositionField("", R.mipmap.scallop_spice_foreground, getString(R.string.Title_scallop_spice)));
        field.add(new PositionField("", R.mipmap.shrimp_spice_foreground, getString(R.string.Title_shrimp_spice)));
        field.add(new PositionField("", R.mipmap.tuna_spice_foreground, getString(R.string.Title_tuna_spice)));
        field.add(new PositionField("", R.mipmap.eel_spice_foreground, getString(R.string.Title_eel_spice)));
        field.add(new PositionField("", R.mipmap.crab_spice_foreground, getString(R.string.Title_crab_spice)));
        field.add(new PositionField("", R.mipmap.chuka_foreground, getString(R.string.Title_chuka)));
        field.add(new PositionField("", R.mipmap.flying_fish_caviar_foreground, getString(R.string.Title_flying_fish_caviar)));
        field.add(new PositionField("", R.mipmap.red_caviar_foreground, getString(R.string.Title_red_caviar)));
        return field;
    }

    private ArrayList<PositionField> Italian() {
        ArrayList<PositionField> field = new ArrayList<>();
        field.add(new PositionField("", R.mipmap.italian_cuisine_foreground, "Coming soon"));
        return field;
    }

    private ArrayList<PositionField> Salad() {
        ArrayList<PositionField> field = new ArrayList<>();
        field.add(new PositionField(getString(R.string.caesar_with_chicken), R.mipmap.caesar_with_chicken_foreground, getString(R.string.Title_caesar_with_chicken)));
        field.add(new PositionField(getString(R.string.caesar_with_shrimp), R.mipmap.caesar_with_shrimp_foreground, getString(R.string.Title_caesar_with_shrimp)));
        field.add(new PositionField(getString(R.string.chuka_with_nut_sauce), R.mipmap.chuka_with_nut_sauce_foreground, getString(R.string.Title_chuka_with_nut_sauce)));
        field.add(new PositionField(getString(R.string.kumotori), R.mipmap.kumotori_foreground, getString(R.string.Title_kumotory)));
        field.add(new PositionField(getString(R.string.sendai), R.mipmap.sendai_foreground, getString(R.string.Title_sendai)));
        field.add(new PositionField(getString(R.string.keiko), R.mipmap.keiko_foreground, getString(R.string.Title_keiko)));
        field.add(new PositionField(getString(R.string.toruko), R.mipmap.toruko_foreground, getString(R.string.Title_toruko)));
        field.add(new PositionField(getString(R.string.akarui), R.mipmap.akarui_foreground, getString(R.string.Title_akarui)));
        field.add(new PositionField(getString(R.string.nicoise), R.mipmap.nicoise_foreground, getString(R.string.Title_nicoise)));
        field.add(new PositionField(getString(R.string.shinshiro), R.mipmap.shinshiro_foreground, getString(R.string.Title_shinshiro)));
        field.add(new PositionField(getString(R.string.greek_salad), R.mipmap.greek_salad_foreground, getString(R.string.Title_greek_salad)));
        field.add(new PositionField(getString(R.string.salmon_salad), R.mipmap.salmon_salad_foreground, getString(R.string.Title_salmon_salad)));
        field.add(new PositionField(getString(R.string.green_salad_with_edamame_and_mozzarella), R.mipmap.green_salad_with_edamame_and_mozzarella_foreground, getString(R.string.Title_green_salad_with_edamame_and_mozzarella)));
        return field;
    }

    private ArrayList<PositionField> Desserts() {
        ArrayList<PositionField> field = new ArrayList<>();
        field.add(new PositionField(getString(R.string.kuro_eru), R.mipmap.kuro_eru_foreground, getString(R.string.Title_kuro_eru)));
        field.add(new PositionField(getString(R.string.manila_roll), R.mipmap.manila_roll_foreground, getString(R.string.Title_manila_roll)));
        field.add(new PositionField(getString(R.string.fruit_roll), R.mipmap.fruit_roll_foreground, getString(R.string.Title_fruit_roll)));
        field.add(new PositionField(getString(R.string.chocolate_roll), R.mipmap.chocolate_roll_foreground, getString(R.string.Title_chocolate_roll)));
        field.add(new PositionField(getString(R.string.roku_san), R.mipmap.roku_san_foreground, getString(R.string.Title_roku_san)));
        field.add(new PositionField(getString(R.string.amai_miru), R.mipmap.amai_miru_foreground, getString(R.string.Title_amai_miru)));
        field.add(new PositionField(getString(R.string.cheesecake), R.mipmap.cheesecake_foreground, getString(R.string.Title_cheesecake)));
        field.add(new PositionField(getString(R.string.tiramisu), R.mipmap.tiramisu_foreground, getString(R.string.Title_tiramisu)));
        field.add(new PositionField(getString(R.string.medovik), R.mipmap.medovik_foreground, getString(R.string.Title_medovik)));
        field.add(new PositionField(getString(R.string.red_velvet), R.mipmap.red_velvet_foreground, getString(R.string.Title_red_velvet)));
        return field;
    }

    private ArrayList<PositionField> Drinks() {
        ArrayList<PositionField> field = new ArrayList<>();
        field.add(new PositionField("", R.mipmap.drinks_foreground, "Coming soon"));
        return field;
    }

    public void ChangePosition(int position) {
        adapter_position = new RecyclerPosition(getContext(), this.position.get(position), ListenerPosition);
        ListPosition.setAdapter(adapter_position);
    }
}