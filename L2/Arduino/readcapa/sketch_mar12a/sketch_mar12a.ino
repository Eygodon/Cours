int etat = 0;  // 0 au début, 1 pendant la charge
               // 2 pendant la décharge, 3 quand c'est fini
long previousMillis = 0; 
long interval = 10;  // nombre de millisecondes entre chaque mesure


void setup() {   

  pinMode(7, OUTPUT);  // alimentation du condensateur
  Serial.begin(9600);  

  // dans un premier temps, on s'assure que le condensateur est 
  // completement déchargé

  Serial.println("Preparation du condensateur");
  digitalWrite(7,LOW);
  delay(2000);

  // nouvel etat:  charge du condensateur
  etat = 1;
  Serial.println("Charge du condensateur");
  digitalWrite(7,HIGH);  // on met en marche l'alimentation

}


void loop() {

  unsigned long currentMillis = millis();
  int tension;

  if(currentMillis - previousMillis >= interval) {
    
    // il est temps de prendre une nouvelle mesure

    previousMillis = currentMillis;

    if (etat == 1) {  // charge du condensateur
      tension = analogRead(A0);
      if (tension < 1020){  // pas completement chargé
        Serial.println(tension);        
      }
      else{  // completement chargé
        // on change d'état:  décharge du condensateur
       
        etat = 2;
        Serial.println("Decharge du condensateur");
        digitalWrite(7,LOW);  // désactivation de l'alimentation
      }
    }

    if (etat == 2) {  // décharge
      tension = analogRead(A0);
      if (tension > 2){ // pas completement déchargé
        Serial.println(tension);
      }
      else {  // completement déchargé
        etat = 3;  // on change d'état:  tout est terminé
      }

    }
  }


}
