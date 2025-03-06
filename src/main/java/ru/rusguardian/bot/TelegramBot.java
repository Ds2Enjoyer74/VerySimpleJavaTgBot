package ru.rusguardian.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {

        String chatId = update.getMessage().getChatId().toString();
        String text = update.getMessage().getText();


        String firstname = update.getMessage().getChat().getFirstName();
        SendMessage sendMessage = new SendMessage();
        if (text.equals("/start")) {
            sendMessage.setChatId(chatId);
            sendMessage.setText("Привет, " + firstname + ", введи сюда свои сумму и на что потратил!");
            sendMessage.setText("Привет " + firstname + ", введи сюда свои сумму и на что потратил!");
            try {
                this.execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        } else {
            sendMessage.setChatId(chatId);
            sendMessage.setText(text);
            sendMessage.setText(text);
            try {
                this.execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }


    }

    @Override
    public String getBotUsername() {
        return "TgBotForMe123_bot";
    }
    @Override
    public String getBotToken() {
        return "Your Token";
    }
}
