package com.mygdx.game.payment;

import com.mygdx.game.enumerable.Preferences;
import com.mygdx.game.enumerable.Purchases;

/**
 * Refatorado para remover a dependência direta do gdx-pay temporariamente.
 * Quando você decidir implementar as compras, basta re-adicionar o "implements PurchaseObserver"
 */
public class CustomPurchaseObserver {

    public void handleRestoreSuccess() {
        System.out.println("Google Billing - RESTORE with success!");
        // Sua lógica original usando as Preferences que já limpamos
        Preferences.PURCHASES_RESTORED.setPropertyAsBoolean(true);
    }

    public void onPurchaseSuccess(String identifier) {
        System.out.println("Google Billing - PURCHASE with success!");
        
        if (identifier.equals(Purchases.PURCHASE_ID.getValue())) {
            // Aqui você libera o conteúdo pro jogador
            // Exemplo: Preferences.REMOVED_ADS.setPropertyAsBoolean(true);
        }
    }
}
