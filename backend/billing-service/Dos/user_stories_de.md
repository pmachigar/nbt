# User Stories für den Abrechnungsservice

Basierend auf den implementierten Funktionen in `BillingServiceImpl.java`, `Invoice.java` und `BillingRepository.java` finden Sie hier die User Stories, die das Wesentliche der Codebasis erfassen.

## Funktion 1: Automatisierte Rechnungsgenerierung (`generateInvoice`)

> **US01: Automatisierte Abrechnung für Abonnements auslösen**
> **Als** internes System (z. B. Abonnement-Service oder Scheduler),  
> **Möchte ich** die Erstellung einer Rechnung für einen bestimmten Benutzer und seine aktiven Abonnements auslösen,  
> **Damit** der Abrechnungszyklus des Benutzers automatisch verarbeitet und protokolliert wird.
> 
> *Akzeptanzkriterien (aus dem Codekontext):*
> - Die Anfrage muss die `userId` sowie eine Liste von `subscriptionIds` enthalten.
> - Ein neues `Invoice`-Dokument muss erstellt und in der MongoDB-Instanz `billing-db` gespeichert werden.
> - Der Rechnungsstatus ist standardmäßig auf `PENDING` gesetzt.
> - Das System gibt die generierte Rechnungs-ID und den Gesamtbetrag über eine gRPC-Antwort zurück.

> **US02: Detaillierte Postenaufschlüsselung der Rechnung**
> **Als** Endnutzer,  
> **Möchte ich** eine detaillierte Aufschlüsselung meiner Gebühren auf der generierten Rechnung sehen,  
> **Damit** ich genau verstehe, für welche Abonnementdienste ich bezahle.
> 
> *Akzeptanzkriterien (aus dem Codekontext):*
> - Für jede übermittelte Abonnement-ID muss dem Rechnungsdokument ein `InvoiceItem` hinzugefügt werden.
> - Jeder Posten muss eine Beschreibung ("Service Charge for Subscription [ID]"), eine Menge und einen berechneten Betrag enthalten.
> - Die Gesamtrechnung (Invoice) muss den `totalValue` über alle generierten Posten genau summieren.

## Funktion 2: Abruf der Rechnungsübersicht (`getInvoices`)

> **US03: Persönlichen Rechnungsverlauf einsehen**
> **Als** Endnutzer,  
> **Möchte ich** eine vollständige Liste all meiner Rechnungen abrufen,  
> **Damit** ich vergangene Zahlungen überprüfen und meinen aktuellen, ausstehenden Saldo einsehen kann.
> 
> *Akzeptanzkriterien (aus dem Codekontext):*
> - Die Anfrage muss eine gültige `userId` bereitstellen.
> - Der Service fragt MongoDB ab (`BillingRepository.findByUserId()`), um alle historischen Rechnungen dieses Benutzers abzurufen.
> - Das System gibt eine serialisierte Liste von Rechnungen (einschließlich Ausstellungsdaten, Status und einzelnen Rechnungsposten) über den gRPC-Endpunkt zurück.

> **US04: Zugriff auf Abrechnungsdaten für den Support**
> **Als** Administrator oder Kundendienstmitarbeiter,  
> **Möchte ich** den Abrechnungsservice nach den Rechnungen eines bestimmten Benutzers/Mandanten abfragen,  
> **Damit** ich Benutzer bei Rechnungskonflikten oder Überprüfungen des Zahlungsverlaufs unterstützen kann.
> 
> *Akzeptanzkriterien (aus dem Codekontext):*
> - Nutzt denselben `getInvoices`-Endpunkt.
> - Muss alle Rechnungen zurückgeben, unabhängig davon, ob ihr Status `PENDING` oder bereits `PAID` ist.
