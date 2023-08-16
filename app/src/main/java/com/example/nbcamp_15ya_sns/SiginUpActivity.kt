package com.example.nbcamp_15ya_sns

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class SiginUpActivity : AppCompatActivity() {

    private val id: EditText by lazy { findViewById(R.id.id_ed) }
    private val psw: EditText by lazy { findViewById(R.id.password_ed) }
    private val name: EditText by lazy { findViewById(R.id.name_ed) }
    private val mbti: EditText by lazy { findViewById(R.id.mbti_ed) }
    private val stateM: EditText by lazy { findViewById(R.id.profile_ed) }

    private var nameCheck: Boolean = false
    private var mbtiCheck: Boolean = false

    //지연초기화
    // 이 변수가 사용되는 시점에서 초기화가 된다.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sigin_up_activity)

        mbtiWatcher(mbti)


    }

    fun doubleCheckOnClick(view: View) {

        val inputid = id.text.toString()
        if (userManager.userList.find { it.id == inputid } != null
            || inputid.isEmpty()) {

           toast("불가능한 아이디입니다.")
            nameCheck = false

        } else{
            toast("사용 가능한 아이디입니다.")
            nameCheck = true
        }
    }

    fun signupOnClick(view: View) {

        val inputId = id.text.toString()
        val inputpsw = psw.text.toString()
        val inputname = name.text.toString()
        val inputmbti = mbti.text.toString()
        val inputstateM = stateM.text.toString()

        when {
            nameCheck == false -> toast("아이디 중복 체크를 해주세요!!")

            checkEmpty(inputpsw) || checkEmpty(inputname) || checkEmpty(inputmbti)
            -> checkMessage(inputPsw = inputpsw, inputName = inputname, inputMBTI = inputmbti)

            else -> {
                userManager.userList.add(
                    User(
                        id = inputId,
                        password = inputpsw,
                        name = inputname,
                        mbti = inputmbti,
                        stateM = inputstateM
                    )
                )
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }

    }

    fun finishOnClick(view: View) {
        finish()
    }



    fun checkMessage(inputPsw: String, inputName: String, inputMBTI: String) {

        when {

            checkEmpty(inputPsw) && checkEmpty(inputName) && checkEmpty(inputMBTI) -> toast("소개글을 제외한 공백을 확인해주세요")

            checkEmpty(inputPsw) && checkEmpty(inputName) -> toast("비밉번호와 이름을 입력해주세요")

            checkEmpty(inputPsw) && checkEmpty(inputMBTI) -> toast("비밉번호와 mbti를 입력해주세요")

            checkEmpty(inputMBTI) && checkEmpty(inputName) -> toast("mbti와 이름을 입력해주세요")

            checkEmpty(inputPsw) -> toast("비밀번호를 확인해주세요")

            checkEmpty(inputName) -> showDialog("이름",name)

            checkEmpty(inputMBTI) -> showMBTIDialog("MBTI")

        }

    }

    fun toast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    fun checkEmpty(id: String): Boolean {
        return id.trim().isEmpty()
    }

    fun isMBTI(mbti: String): Boolean {
        return mbti.matches(Regex("[EI][SN][TF][JP]"))
    }

    fun mbtiWatcher(view: View) {
        mbti.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                val text:TextView = findViewById(R.id.mbti_check_text)
                if(!isMBTI(s.toString())){
                    text.text = "잘못된 MBTI입니다."
                    mbtiCheck = false
                }else{
                    text.text = "올바른 MBTI입니다."
                    mbtiCheck = true
                }

            }
        })
    }

    fun showMBTIDialog(title: String) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.custom_mbti_dialog, null)
        val input: EditText = dialogView.findViewById(R.id.custom_edit_text)

        builder.setTitle(title)
        builder.setView(dialogView)

        builder.setPositiveButton("확인") { dialog, _ ->
            val inputText = input.text.toString()

            if (isMBTI(inputText)) mbti.setText(inputText)
            else toast("올바른 mbti를 입력해주세요")

            dialog.dismiss()
        }

        builder.setNegativeButton("취소") { dialog, _ ->
            dialog.dismiss()
        }

        val dialog = builder.create()
        dialog.show()
    }

    fun showDialog(title: String,id:EditText) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.custom_text_dialog, null)
        val input: EditText = dialogView.findViewById(R.id.costom_text_edit)

        builder.setTitle(title)
        builder.setView(dialogView)

        builder.setPositiveButton("확인") { dialog, _ ->
            val inputText = input.text.trim().toString()

            if (inputText.isNotEmpty()) {
                id.setText(inputText)
                dialog.dismiss()
            }else{
                toast("${title}을 입력해주세요")
            }

        }

        builder.setNegativeButton("취소") { dialog, _ ->
            dialog.dismiss()
        }

        val dialog = builder.create()
        dialog.show()
    }



}
