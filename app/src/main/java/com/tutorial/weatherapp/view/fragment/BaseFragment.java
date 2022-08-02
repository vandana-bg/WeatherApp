package com.tutorial.weatherapp.view.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.support.v4.app.Fragment;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.ProgressBar;

import com.lsjwzh.widget.materialloadingprogressbar.CircleProgressBar;
import com.tutorial.weatherapp.R;

import java.io.File;

public class BaseFragment extends Fragment {
    int permissionNeeded;
    public File mImageFile;
    private Dialog mDialog;
    private AlertDialog.Builder builder;
    private RecyclerView recylcerView;
    public PopupWindow mPopupWindow;
    private AlertDialog mDialogProgress;
    private Dialog mAlertDialog;
    private Dialog progressDialog;


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
    }

    public void showProgress() {
        mDialog = new Dialog(getActivity());
        mDialog.setOwnerActivity(getActivity());
        // no tile for the dialog
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(R.layout.prograss_bar_dialog);
        ProgressBar mProgressBar = mDialog.findViewById(R.id.progress_bar);
        //  mProgressBar.getIndeterminateDrawable().setColorFilter(context.getResources()
        // .getColor(R.color.material_blue_gray_500), PorterDuff.Mode.SRC_IN);
        mProgressBar.setVisibility(View.VISIBLE);
        // you can change or add this line according to your need
        mProgressBar.setIndeterminate(true);
        mDialog.setCancelable(false);
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.show();

    }

    public void hideProgress() {
        if (mDialog != null) {
            mDialog.dismiss();
            mDialog = null;
        }
    }

    public boolean isShowing() {
        if (mDialog != null && mDialog.isShowing())
            return true;
        else
            return false;


    }

    public void setFocus(Activity activity, EditText editText) {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
    }

    public boolean isNetworkAvailable() {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    public void showLoadingDialog() {
        progressDialog = new Dialog(getActivity());
        progressDialog.requestWindowFeature(1);
        progressDialog.setContentView(R.layout.custom_dialog);
        progressDialog.setCancelable(false);
        progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        ((CircleProgressBar) progressDialog.findViewById(R.id.progressBar)).setColorSchemeColors(SupportMenu.CATEGORY_MASK, ViewCompat.MEASURED_STATE_MASK);
        progressDialog.show();
    }

    public void hideLoadingDialog() {
        if (progressDialog != null && progressDialog.isShowing())
            progressDialog.dismiss();
    }


}
