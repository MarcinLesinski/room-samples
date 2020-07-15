package com.example.room_samples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import com.example.room_samples.embedded.EmbeddedAddress;
import com.example.room_samples.embedded.EmbeddedAddress2;
import com.example.room_samples.embedded.EmbeddedUser;
import com.example.room_samples.one_to_one.OtoUser;
import com.example.room_samples.one_to_one.OtoUserEntity;
import com.example.room_samples.simple_read_write.User;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database-name").build();
    }
    private void embeddedOtoUSer() {
        OtoUser otoUser = new OtoUser();
        otoUser.user = new OtoUserEntity();
        otoUser.user.name = "Marcin";
        otoUser.otoAddress.adr = "SomeCity";

        Completable
                .create(new CompletableOnSubscribe() {
                    @Override
                    public void subscribe(CompletableEmitter emitter) throws Exception {
                        db.otoUserDao().insertUser(otoUser);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

    private void embeddedAdd() {
        EmbeddedUser user = new EmbeddedUser();
        user.firstName = "Nice guy";
        user.embeddedAddress = new EmbeddedAddress();
        user.embeddedAddress2 = new EmbeddedAddress2();
        user.embeddedAddress.city = "Kraków";
        user.embeddedAddress.street = "dolna street";
        user.embeddedAddress2.city = "Wyszków";
        user.embeddedAddress2.street2 = "gorna street";

        Completable
                .create(new CompletableOnSubscribe() {
                    @Override
                    public void subscribe(CompletableEmitter emitter) throws Exception {
                        db.embeddedUserDao().insertUser(user);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action() {
                    @Override
                    public void run() throws Exception {

                    }
                });
    }

    private void EmbeddedRead() {
        db.embeddedUserDao().getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(System.out::println);
    }


    private void clear() {
        getApplicationContext().deleteDatabase("database-name");
    }

    private void showAllUsers() {
        db.userDao().getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<User>>() {
                    @Override
                    public void accept(List<User> users) throws Exception {
                        users.forEach(user -> {
                            if (user != null) {
                                Log.d("D", user.lastName);
                            }
                        });
                    }
                });
    }

    private void add5Users() {
        final User user = new User();
        user.firstName = "Marcin";
        user.lastName = "Lesiński";

        final User user2 = new User();
        user2.firstName = "Kaja";
        user2.lastName = "ZMaja";

        final User user3 = new User();
        user3.firstName = "Zygmunt";
        user3.lastName = "Doniczka";

        final User user4 = new User();
        user4.firstName = "Marek";
        user4.lastName = "Arek";

        final User user5 = new User();
        user5.firstName = "Filip";
        user5.lastName = "Pilif";

        Completable
                .create(new CompletableOnSubscribe() {
                    @Override
                    public void subscribe(CompletableEmitter emitter) throws Exception {
                        db.userDao().insertAll(user, user2, user3, user4, user5);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();

    }
}