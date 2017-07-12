package br.andre.cdp.cdp_android.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import br.andre.cdp.cdp_android.R;
import br.andre.cdp.cdp_android.domain.Pelada;
import br.andre.cdp.cdp_android.domain.model.NewTeam;
import br.andre.cdp.cdp_android.mvp.peladateam.createteam.ITeamView;
import br.andre.cdp.cdp_android.mvp.peladateam.createteam.TeamPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by helio on 7/10/17.
 */

public class CreateTeamActivity extends AppCompatActivity implements ITeamView {

    @BindView(R.id.etTeam_Name)
    EditText etTeam_name;

    @BindView(R.id.spTeam_pelada)
    Spinner spTeam_pelada;

    @BindView(R.id.spTeam_Color)
    Spinner spTeam_color;

    TeamPresenter _presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        init();
    }

    @Override
    public void init() {
        ButterKnife.bind(this);

        _presenter = new TeamPresenter(getBaseContext(), this);

        // Load color spinner
        loadCollorSpinner();
        getPeladaSpinner();
    }

    @OnClick(R.id.btnTeam_save)
    @Override
    public void OnClickSave() {

        NewTeam newTeam = new NewTeam(etTeam_name.getText().toString(), "");

        try {

            _presenter.save(newTeam);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void loadCollorSpinner() {

        List<String> colors = new ArrayList<>();

        colors.add("Black");
        colors.add("Green");
        colors.add("Yellow");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, colors);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTeam_color.setAdapter(dataAdapter);

    }

    @Override
    public void getPeladaSpinner() {

        _presenter.getPeladas();

    }

    @Override
    public void loadPeladaSpinner(List<Pelada> peladaList) {

        ArrayAdapter<Pelada> dataAdapter = new ArrayAdapter<Pelada>(this, android.R.layout.simple_spinner_item, peladaList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTeam_pelada.setAdapter(dataAdapter);

    }

    @Override
    public void doAfterSave() {

    }

    @Override
    public void returnSuccess(String msg) {

    }

    @Override
    public void returnError(String msg) {

    }
}
