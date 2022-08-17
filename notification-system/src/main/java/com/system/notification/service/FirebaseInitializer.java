package com.system.notification.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.util.logging.Logger;

@Service
public class FirebaseInitializer {

    @Value("${app.firebase-config-file}")
    String firebaseConfigPath;

    // Create logger to show msgs into console
    Logger logger = (Logger) LoggerFactory.getLogger(FirebaseInitializer.class);

    @PostConstruct
    public void firebaseIntialize() {
        try {
            FileInputStream serviceAccount =
                    new FileInputStream(firebaseConfigPath);

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

}
