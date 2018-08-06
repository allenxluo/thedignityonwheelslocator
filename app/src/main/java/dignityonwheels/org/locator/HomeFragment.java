package dignityonwheels.org.locator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment implements View.OnClickListener{

    public HomeFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View homeFragmentView =  inflater.inflate(R.layout.fragment_home, container, false);

        Button newFragButton = (Button) homeFragmentView.findViewById(R.id.btnlocation);

        newFragButton.setOnClickListener(this);

        return homeFragmentView;
    }

    public void onClick(View view){
        Fragment fragment = null;
        switch (view.getId()){
            case R.id.btnlocation:
                fragment = new ScheduleFragment();
                replaceFragment(fragment);
                break;
        }
    }

    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
