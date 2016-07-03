package rationalduos.atulsoori.nofucksgiven;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Random;

import rationalduos.atulsoori.nofucksgiven.adapters.DynamicPagerAdapter;
import rationalduos.atulsoori.nofucksgiven.cardViews.ImageCard;
import rationalduos.atulsoori.nofucksgiven.cardViews.MarkDownCard;
import rationalduos.atulsoori.nofucksgiven.cardViews.TextCard;

public class CardHolderFragment extends Fragment {

    private TextCard getRandomTextCard() {
        Random t = new Random();
        return createTextCard("Random " + t.nextInt());
    }

    private ImageCard getRandomImageCard() {
        return createImageCard("https://pixabay.com/static/uploads/photo/2016/01/14/01/41/image-view-1139204_960_720.jpg");
    }

    private MarkDownCard getRandomMarkdownCard() {
        return createMarkDownCard("https://raw.githubusercontent.com/BucketDevelopers/NFGAssets/master/assets/texts/sample-text.md");
    }

    private ImageCard createImageCard(String Url){
        Bundle bundle = new Bundle();
        bundle.putString("imageUrl", Url);
        ImageCard mCard = new ImageCard();
        mCard.setArguments(bundle);
        return mCard;
    }

    private MarkDownCard createMarkDownCard(String Url){
        Bundle bundle = new Bundle();
        bundle.putString("markdownUrl", Url);
        MarkDownCard mkCard = new MarkDownCard();
        mkCard.setArguments(bundle);
        return mkCard;
    }

    private TextCard createTextCard(String textContent){
        Bundle bundle = new Bundle();
        bundle.putString("textContent",textContent);
        TextCard tCard = new TextCard();
        tCard.setArguments(bundle);
        return tCard;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup vg,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.card_holder_fragment_layout, vg, false);
        ViewPager pager = (ViewPager) view.findViewById(R.id.viewPager);

        DynamicPagerAdapter mDynamicPagerAdapter = new DynamicPagerAdapter(getChildFragmentManager());

        mDynamicPagerAdapter.addFragment(getRandomImageCard());
        mDynamicPagerAdapter.addFragment(getRandomMarkdownCard());
        mDynamicPagerAdapter.addFragment(getRandomTextCard());

        if (pager != null) {
            pager.setAdapter(mDynamicPagerAdapter);
        } else {
            Log.d("NFG", "Pager not found");
        }
        return view;
    }

}