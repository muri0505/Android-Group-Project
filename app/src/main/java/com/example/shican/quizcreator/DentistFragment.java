package com.example.shican.quizcreator;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
/**
 *this class is a fragment for dentist type questions
 * @author Nan Jiang
 */
public class DentistFragment extends Fragment {

    String braces, medicalBenefits;
    RadioGroup radioBrace, radioMedicalBenefit;
 //   RadioButton braceTrueBtn, braceFalseBtn, MedicalBenefitTrueBtn;
 @Override
 public View onCreateView(LayoutInflater inflater, ViewGroup container,
                          Bundle savedInstanceState) {
     String[] data = ((RegistrationFormActivity) getActivity()).getDataToFragment();
     View view = inflater.inflate(R.layout.activity_dentist_fragment_detail,
             container, false);
     radioBrace = (RadioGroup) view.findViewById(R.id.radioBraces);
     radioMedicalBenefit = (RadioGroup) view.findViewById(R.id.radioMedicalBenefits);

     if (data != null && data[2].equalsIgnoreCase("dentist")) {
         if (data[0].equalsIgnoreCase("yes")) {
             radioBrace.check(R.id.braces_true);
         } else {
             radioBrace.check(R.id.braces_false);
         }
         if (data[1].equalsIgnoreCase("yes")) {
             radioMedicalBenefit.check(R.id.medical_benefits_true);
         } else {
             radioMedicalBenefit.check(R.id.medical_benefits_false);
         }
     } else {
         radioBrace.check(R.id.braces_true);
         radioMedicalBenefit.check(R.id.medical_benefits_true);
     }

     return view;
 }
    public String[] getData (){
        braces = radioBrace.getCheckedRadioButtonId() == R.id.braces_true? "Yes": "No";
        medicalBenefits = radioMedicalBenefit.getCheckedRadioButtonId() == R.id.medical_benefits_true? "Yes":"No";

        return (new String[]{braces, medicalBenefits});
    }
}
