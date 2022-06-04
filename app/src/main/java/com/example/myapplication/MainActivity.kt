package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    val db = Firebase.firestore
    private lateinit var auth: FirebaseAuth // 객체의 공유 인스턴스
    private val RC_SIGN_IN = 9001
    private var googlesSignInClient: GoogleSignInClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = Firebase.auth

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("407690812242-hvv049lu3jt37j5qvqchcp67g4100uj0.apps.googleusercontent.com")
            .requestEmail()
            .build()
        var googleSignInClient = GoogleSignIn.getClient(this, gso)

        val signInGoogleBtn: SignInButton = findViewById(R.id.sign_in_button) //구글 sign in 버튼 객체
        signInGoogleBtn.setOnClickListener { // google login button
            val signInIntent = googleSignInClient.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try { //로그인 성공시
                val account = task.getResult(ApiException::class.java)!!

                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {//로그인 실패
            }
        }
    }
    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task -> //파이어 베이스에 등록
                if (task.isSuccessful) { //성공
                    val user = auth.currentUser
                    Log.d("xxxx ", user.toString())
                } else { //실패
                    Log.d("xxxx ", "signInWithCredential:failure", task.exception)
                }
            }
    }
    private fun firebaseAuthSignOut(){ //로그 아웃 시키기
        Firebase.auth.signOut()
        googlesSignInClient!!.signOut()
    }
}