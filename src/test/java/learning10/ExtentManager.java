package learning10;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports report;

    public static ExtentReports getInstance() {
        if (report == null) {
            String reportPath = System.getProperty("user.dir") + "/reports/report.html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

            sparkReporter.config().setDocumentTitle("Automation Reports");
            sparkReporter.config().setReportName("Functional Report");
            sparkReporter.config().setTheme(Theme.STANDARD);

            report = new ExtentReports();
            report.attachReporter(sparkReporter);
            report.setSystemInfo("OS", "Windows 11");
            report.setSystemInfo("Tester Name", "Taj");
            report.setSystemInfo("Browser", "Chrome");
        }
        return report;
    }
}
