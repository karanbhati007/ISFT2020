package com.priyanka.ifst;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.shockwave.pdfium.PdfDocument;

import java.util.List;

public class spoc extends AppCompatActivity implements OnPageChangeListener, OnLoadCompleteListener {
    private static final String TAG = schedule.class.getSimpleName();
    public static final String SAMPLE_FILE = "spoc.pdf";
    PDFView pdfView;
    Integer pageNumber = 0;
    String pdfFileName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spoc);
        pdfView= (PDFView)findViewById(R.id.pdspoc);
        displayFromAsset(SAMPLE_FILE);
    }

    private void displayFromAsset(String sampleFile) {
        pdfFileName = sampleFile;

        pdfView.fromAsset(SAMPLE_FILE)
                .defaultPage(pageNumber)
                .enableSwipe(true)

                .swipeHorizontal(false)
                .onPageChange(this)
                .enableAnnotationRendering(true)
                .onLoad(this)
                .scrollHandle(new DefaultScrollHandle(this))
                .load();
    }

    @Override
    public void loadComplete(int nbPages) {
        PdfDocument.Meta meta = pdfView.getDocumentMeta();
        printBookmarksTree(pdfView.getTableOfContents(), "-");
    }

    private void printBookmarksTree(List<PdfDocument.Bookmark> tree, String sep) {
        for (PdfDocument.Bookmark b : tree) {

            Log.e(TAG, String.format("%s %s, p %d", sep, b.getTitle(), b.getPageIdx()));

            if (b.hasChildren()) {
                printBookmarksTree(b.getChildren(), sep + "-");
            }
        }
    }

    @Override
    public void onPageChanged(int page, int pageCount) {
        pageNumber = page;
        setTitle(String.format("%s %s / %s", pdfFileName, page + 1, pageCount));

    }
}
