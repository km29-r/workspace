// フォームが送信されたときの処理を設定
document.getElementById("contactForm").addEventListener("submit", async function(event) {
    event.preventDefault(); // デフォルトのフォーム送信を防ぐ（ページ遷移を防ぐ）

    // 入力されたデータを取得
    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const message = document.getElementById("message").value;

    // 送信するデータをオブジェクトにまとめる
    const data = {
        name: name,
        email: email,
        message: message
    };

    try {
        // Spring Boot の API に問い合わせデータを送信
        const response = await fetch("http://localhost:8080/contacts", {
            method: "POST", // HTTPメソッドは「POST」
            headers: {
                "Content-Type": "application/json" // JSONデータを送ることを指定
            },
            body: JSON.stringify(data) // JavaScriptのオブジェクトをJSON文字列に変換
        });

        // 成功した場合
        if (response.ok) {
            document.getElementById("responseMessage").innerText = "送信が完了しました！";
            document.getElementById("contactForm").reset(); // フォームをリセット
        } else {
            document.getElementById("responseMessage").innerText = "エラーが発生しました。";
        }
    } catch (error) {
        // ネットワークエラーなどが発生した場合
        document.getElementById("responseMessage").innerText = "サーバーに接続できませんでした。";
        console.error("エラー:", error);
    }
});
