//
// DO NOT EDIT THIS FILE.Generated using AndroidAnnotations 3.3.2.
//  You can create a larger work that contains this file and distribute that work under terms of your choice.
//


package com.hanyu.luckychild.ui.order;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hanyu.luckychild.R.id;
import com.hanyu.luckychild.R.layout;
import com.hanyu.luckychild.view.NoScrollListView;
import org.androidannotations.api.builder.ActivityIntentBuilder;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class OrderDetailActivity_
    extends OrderDetailActivity
    implements HasViews, OnViewChangedListener
{

    private final OnViewChangedNotifier onViewChangedNotifier_ = new OnViewChangedNotifier();
    public final static String TYPE_EXTRA = "type";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(onViewChangedNotifier_);
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        OnViewChangedNotifier.replaceNotifier(previousNotifier);
        setContentView(layout.activity_order_detail);
    }

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
        injectExtras_();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    @Override
    public void setContentView(View view, LayoutParams params) {
        super.setContentView(view, params);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    public static OrderDetailActivity_.IntentBuilder_ intent(Context context) {
        return new OrderDetailActivity_.IntentBuilder_(context);
    }

    public static OrderDetailActivity_.IntentBuilder_ intent(android.app.Fragment fragment) {
        return new OrderDetailActivity_.IntentBuilder_(fragment);
    }

    public static OrderDetailActivity_.IntentBuilder_ intent(android.support.v4.app.Fragment supportFragment) {
        return new OrderDetailActivity_.IntentBuilder_(supportFragment);
    }

    @Override
    public void onViewChanged(HasViews hasViews) {
        tv_title = ((TextView) hasViews.findViewById(id.tv_title));
        tv_commit = ((TextView) hasViews.findViewById(id.tv_commit));
        iv_left = ((ImageView) hasViews.findViewById(id.iv_left));
        list_view = ((NoScrollListView) hasViews.findViewById(id.list_view));
        ll_bottom_menu = ((LinearLayout) hasViews.findViewById(id.ll_bottom_menu));
        tv_status = ((TextView) hasViews.findViewById(id.tv_status));
        tv_cancel = ((TextView) hasViews.findViewById(id.tv_cancel));
        if (iv_left!= null) {
            iv_left.setOnClickListener(new OnClickListener() {


                @Override
                public void onClick(View view) {
                    OrderDetailActivity_.this.back();
                }

            }
            );
        }
        if (tv_commit!= null) {
            tv_commit.setOnClickListener(new OnClickListener() {


                @Override
                public void onClick(View view) {
                    OrderDetailActivity_.this.commit();
                }

            }
            );
        }
        if (tv_cancel!= null) {
            tv_cancel.setOnClickListener(new OnClickListener() {


                @Override
                public void onClick(View view) {
                    OrderDetailActivity_.this.cancel();
                }

            }
            );
        }
        init();
    }

    private void injectExtras_() {
        Bundle extras_ = getIntent().getExtras();
        if (extras_!= null) {
            if (extras_.containsKey(TYPE_EXTRA)) {
                type = extras_.getInt(TYPE_EXTRA);
            }
        }
    }

    @Override
    public void setIntent(Intent newIntent) {
        super.setIntent(newIntent);
        injectExtras_();
    }

    public static class IntentBuilder_
        extends ActivityIntentBuilder<OrderDetailActivity_.IntentBuilder_>
    {

        private android.app.Fragment fragment_;
        private android.support.v4.app.Fragment fragmentSupport_;

        public IntentBuilder_(Context context) {
            super(context, OrderDetailActivity_.class);
        }

        public IntentBuilder_(android.app.Fragment fragment) {
            super(fragment.getActivity(), OrderDetailActivity_.class);
            fragment_ = fragment;
        }

        public IntentBuilder_(android.support.v4.app.Fragment fragment) {
            super(fragment.getActivity(), OrderDetailActivity_.class);
            fragmentSupport_ = fragment;
        }

        @Override
        public void startForResult(int requestCode) {
            if (fragmentSupport_!= null) {
                fragmentSupport_.startActivityForResult(intent, requestCode);
            } else {
                if (fragment_!= null) {
                    if (VERSION.SDK_INT >= VERSION_CODES.JELLY_BEAN) {
                        fragment_.startActivityForResult(intent, requestCode, lastOptions);
                    } else {
                        fragment_.startActivityForResult(intent, requestCode);
                    }
                } else {
                    if (context instanceof Activity) {
                        Activity activity = ((Activity) context);
                        ActivityCompat.startActivityForResult(activity, intent, requestCode, lastOptions);
                    } else {
                        if (VERSION.SDK_INT >= VERSION_CODES.JELLY_BEAN) {
                            context.startActivity(intent, lastOptions);
                        } else {
                            context.startActivity(intent);
                        }
                    }
                }
            }
        }

        public OrderDetailActivity_.IntentBuilder_ type(int type) {
            return super.extra(TYPE_EXTRA, type);
        }

    }

}
