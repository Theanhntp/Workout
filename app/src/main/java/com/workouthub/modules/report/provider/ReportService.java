package com.workouthub.modules.report.provider;

import android.content.Context;
import com.workouthub.entity.report.PracticeReport;
import com.jjoe64.graphview.series.DataPoint;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReportService extends IReportService {
    public ReportService(Context context) {
        super(context);
    }

    public DataPoint[] getReportGraphData() {
        List<PracticeReport> reports = repo.getPracticeReport().getAll();
        Collections.sort(reports, new StringAsDateComparator());

        int reportCount = reports.size();
        DataPoint[] reportPoints;

        // Khởi tạo kích thước mảng dựa trên số lượng báo cáo
        if (reportCount < 5) {
            reportPoints = new DataPoint[3 + reportCount]; // 3 điểm dữ liệu đầu tiên là 0
            for (int i = 0; i < 3; i++) {
                reportPoints[i] = new DataPoint(i, 0); // Giá trị y là 0 cho các điểm đầu tiên
            }
            // Điền dữ liệu báo cáo vào mảng, bắt đầu từ chỉ số 0
            for (int i = 0; i < reportCount; i++) {
                reportPoints[i + 3] = new DataPoint(i + 3, reports.get(i).getCalo());
            }
        } else {
            // Nếu có đủ báo cáo, chỉ cần khởi tạo mảng với kích thước tương ứng
            reportPoints = new DataPoint[reportCount];
            for (int i = 0; i < reportCount; i++) {
                reportPoints[i] = new DataPoint(i, reports.get(i).getCalo()); // Bắt đầu từ chỉ số 0
            }
        }

        return reportPoints;
    }

    class StringAsDateComparator implements Comparator<PracticeReport> {
        public int compare(PracticeReport lhs, PracticeReport rhs) {
            // Kiểm tra null để tránh NullPointerException
            if (lhs.getDate() == null && rhs.getDate() == null) return 0;
            if (lhs.getDate() == null) return 1; // Đưa lhs sau rhs
            if (rhs.getDate() == null) return -1; // Đưa rhs sau lhs
            return lhs.getDate().compareTo(rhs.getDate());
        }
    }
}
