from flask import Flask, render_template, request
import datetime

app = Flask(__name__)


@app.route("/")
def index():
    return render_template("index.html")


@app.route("/register", methods=["POST"])  # supports "get" by default, but not "post"
def register():
    # Validate Submission
    if not request.form.get("name") or request.form.get("subject") not in [
        "Computer Science",
        "Korean",
        "Philosophy",
    ]:
        return render_template("failure.html")

    name = request.form.get("name")
    subject = request.form.get("subject")
    return render_template("success.html", name=name, subject=subject)
