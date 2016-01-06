package com.bamboo.guava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.bamboo.guava.entity.Person;
import com.google.common.base.Objects;
import com.google.common.base.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Strings;




import butterknife.ButterKnife;
import butterknife.OnClick;

public class BaseToolActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_tool);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_null, R.id.btn_condition,R.id.btn_object})
    public void onClick(View view) {
        if (view.getId() == R.id.btn_null) {
            Optional<String> optional = Optional.fromNullable("cc");
            Log.d("bzy", "" + optional.isPresent() + "," + optional.get());
            String name = null;
            Log.d("bzy", "" + Strings.isNullOrEmpty(name) + "," + Strings.emptyToNull(Strings.nullToEmpty(name)));
        } else if (view.getId() == R.id.btn_condition) {
            String name = null;
            checkNotNull(name,"name is null");
        } else if (view.getId() == R.id.btn_object){
            Log.d("bzy",""+ Objects.equal(null,"a"));
            Person p1 = new Person("a","a");
            Person p2 = new Person("b","b");
            Log.d("bzy",""+p2.compareTo(p1));
        }
    }
}
